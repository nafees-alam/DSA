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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        helper(ans, root, q);
        return ans;
    }

    public void helper(List<List<Integer>> ans, TreeNode root, Queue<TreeNode> q){
        if(root == null){
            return;
        }

        q.add(root);

        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < levelNum; i++){
                TreeNode currNode = q.remove();
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
                temp.add(currNode.val);
            }

            ans.add(temp);
        }
    }
}