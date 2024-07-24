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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder(root, ans);

        Collections.reverse(ans);
        return ans;
    }

    static void levelOrder(TreeNode root, List<List<Integer>> ans){
        if(root == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < levelNum; i++){
                TreeNode curr = q.remove();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }

                temp.add(curr.val);
            }

            ans.add(temp);
        }
    }
}