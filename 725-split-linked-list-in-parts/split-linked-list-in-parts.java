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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        ListNode[] list = new ListNode[k];
        temp = head;

        int minPartlen = size/k;
        int rest = size % k;
        int p = 0;

        while(temp != null){
            int counter = 0;
             if(rest > 0){
                counter = minPartlen + 1;
                rest--;
             } else {
                counter = minPartlen;
             }

             ListNode tempHead = new ListNode();
             list[p++] = tempHead;
             for(int i = 0; i < counter; i++){

                tempHead.val = temp.val;
                temp = temp.next;
                
                if(temp != null && i < counter-1){
                    tempHead.next = new ListNode();
                    tempHead = tempHead.next;
                } else {
                    break;
                }
             }
        }

        return list;
    }
}