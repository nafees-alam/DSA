/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        int parX = -1;
        int parY = -1;

        int levelX = 0;
        int levelY = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            level++;

            if(parX != -1 && parY != -1){
                break;
            }

            for(int i = 0; i < size; i++){
                TreeNode curr = q.remove();

                if(curr.left != null){
                    if(curr.left.val == x){
                        parX = curr.val;
                        levelX = level;
                    } else if(curr.left.val == y){
                        parY = curr.val;
                        levelY = level;
                    }

                    q.add(curr.left);
                }

                if(curr.right != null){
                    if(curr.right.val == x){
                        parX = curr.val;
                        levelX = level;
                    } else if(curr.right.val == y){
                        parY = curr.val;
                        levelY = level;
                    }

                    q.add(curr.right);
                }
            }
        }

        if(parX != parY && levelX == levelY) return true;

        return false;
    }
}