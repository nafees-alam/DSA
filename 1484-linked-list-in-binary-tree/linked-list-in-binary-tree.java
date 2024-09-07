/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        ListNode temp = head;
        return helper(temp, head, root);
    }

    public boolean helper(ListNode temp, ListNode head, TreeNode root){
        if(temp == null){
            return true;
        }

        if(root == null){
            return false;
        }
        if(root.val == temp.val){
            temp = temp.next;
        } else if(root.val == head.val){
            head = head.next;
        } else {
            temp = head;
        }
        boolean left = helper(temp, head, root.left);
        boolean right = helper(temp, head, root.right);

        return left || right;
    }
}