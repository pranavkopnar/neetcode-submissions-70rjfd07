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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        ListNode prev = null;
        int r = 0;
        while (l1 != null || l2 != null || r != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int val = (val1 + val2 + r) % 10;
            r = (val1 + val2 + r) / 10;
            ListNode node = new ListNode(val);
            l3.next = node;
            l3 = node;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return dummy.next;
    }
}
