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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        leafNodes(root1, list1);
        leafNodes(root2, list2);

        System.out.println(list1);
        System.out.println(list2);

        if(list1.size() != list2.size()){
            return false;
        }
        for(int i = 0; i < list1.size(); i++){
            if(!list1.get(i).equals(list2.get(i))){
                return false;
            }
        }
        return true;
    }

    static void leafNodes(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            ans.add(root.val);
            return;
        }

        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }
}