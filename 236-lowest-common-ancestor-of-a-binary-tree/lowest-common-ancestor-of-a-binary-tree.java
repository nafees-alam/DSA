/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root.val == p.val || root.val == q.val){
            return root;
        }

        //left traversal
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //right traversal
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //if left is null
        if(left == null){
            return right;
        }
        //if right is null
        if(right == null){
            return left;
        }

        return root;
    }
}