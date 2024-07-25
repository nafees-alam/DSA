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
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            int sum = 0;
            for(int j = i; j < list.size(); j++){
                sum+= list.get(j);
            }
            map.put(list.get(i), sum);
        }

        gst(root, map);
        return root;
    }

    static void gst(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null){
            return;
        }
        gst(root.left, map);
        root.val = map.get(root.val);
        gst(root.right, map);
    }

    static void inOrder(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }
}