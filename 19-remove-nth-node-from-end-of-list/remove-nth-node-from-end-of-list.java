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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode node = new ListNode();
       node = head;
       int k = 0;
       while(node != null){
           node = node.next;
           k++;
       }

       if(k == 1){
           return null;
       }

       node = head;
       if(k == n) {
           head = head.next;
           return head;
       }
       for(int i = 0; i < k - n - 1; i++){
           node = node.next;
       }

        if(node.next != null){
            node.next = node.next.next;
        }
        
        return head;
    }
}