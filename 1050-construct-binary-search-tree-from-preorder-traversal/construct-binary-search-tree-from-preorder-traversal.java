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
    public TreeNode bstFromPreorder(int[] preorder) {
        int st = 0;
        int en = preorder.length-1;

        return helper(preorder, st, en);
    }

    public TreeNode helper(int[] preOrder, int st, int en){
        if(st > en){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[st]);
        int pivot = en+1;
        for(int i = st; i <= en; i++){
            if(preOrder[i] > root.val){
                pivot = i;
                break;
            }
        }

        root.left = helper(preOrder, st+1, pivot-1);
        root.right = helper(preOrder, pivot, en);

        return root;
    }
}