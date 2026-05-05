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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int size = 0;

        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        size++;

        k = k % size;
        k = size - k;

        temp.next = head;

        while(k-- > 0){
            temp = head;
            head = head.next;
        }
        
        temp.next = null;
        return head;
    }
}