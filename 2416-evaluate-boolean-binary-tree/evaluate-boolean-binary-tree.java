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
    public boolean evaluateTree(TreeNode root) {
        int ans = helper(root, 0);
        if(ans == 0){
            return false;
        } else {
            return true;
        }

    }

    static int helper(TreeNode root, int ans){
        if(root.left == null && root.right == null){
            return root.val;
        }

        int left = helper(root.left, ans);
        int right = helper(root.right, ans);

        if(root.val == 2){
            ans = left + right;
        } else {
            ans = left*right;
        }

        return ans;
    }
}