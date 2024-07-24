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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean toggle = true;

        while(!q.isEmpty()){
            int size = q.size();
            toggle = !toggle;
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.remove();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                temp.add(curr.val);
            }

            if(toggle){
                Collections.reverse(temp);
            }

            ans.add(temp);
        }

        return ans;
    }
}