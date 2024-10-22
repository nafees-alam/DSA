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
        Stack<Integer> st = new Stack<>();

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        while(slow != null){
            st.push(slow.val);
            slow = slow.next;
        }

        if(st.isEmpty()){
            return head.val+head.next.val;
        }

        int ans = 0;

        while(!st.isEmpty()){
            ans = Math.max(ans, head.val+st.pop());
            head = head.next;
        }

        return ans;
    }
}