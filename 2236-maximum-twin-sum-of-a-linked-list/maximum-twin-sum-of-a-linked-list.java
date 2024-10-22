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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode headTemp = reverseLL(slow);

        ListNode temp = head;
        int ans = 0;
        while(temp != slow){
            ans = Math.max(temp.val + headTemp.val, ans);
            temp = temp.next;
            headTemp = headTemp.next;
        }

        return ans;
    }

    public ListNode reverseLL(ListNode st){
        ListNode curr = st;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}