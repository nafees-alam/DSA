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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }

        int st = 0;
        int en = nums.length - 1;

        return helper(nums, st, en);
    }

    public TreeNode helper(int[] nums, int st, int en){
        if(st > en){
            return null;
        }

        int mid = st + (en - st)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, st, mid-1);
        root.right = helper(nums, mid+1, en);

        return root;
    }
}