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
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        Collections.sort(list);

        swap(root, list, new int[]{0});
    }

    public void swap(TreeNode root, ArrayList<Integer> list, int[] i){
        if(root == null || list.size() == 0){
            return;
        }

        swap(root.left, list, i);
        root.val = list.get(i[0]);
        i[0]++;
        swap(root.right, list, i);
    }

    public void inOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}