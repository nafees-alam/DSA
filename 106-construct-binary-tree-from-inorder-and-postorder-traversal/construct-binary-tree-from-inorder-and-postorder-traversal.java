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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
    }

    public TreeNode helper(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> map){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        TreeNode node = new TreeNode(postOrder[postEnd]);
        int inRoot = map.get(node.val);
        int numsLeft = inRoot - inStart;

        //left 
        node.left = helper(postOrder, postStart, postStart+numsLeft-1, inOrder, inStart, inRoot-1, map);

        //right
        node.right = helper(postOrder, postStart+numsLeft, postEnd-1, inOrder, inRoot+1, inEnd, map);

        return node;
    }
}