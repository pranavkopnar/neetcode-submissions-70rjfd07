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
        
        int r = 0;
        ListNode head = null, prev = null;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + r;
            ListNode node = new ListNode(val % 10);

            if (prev == null) head = node;
            else prev.next = node;

            prev = node;

            r = val / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + r;
            ListNode node = new ListNode(val % 10);
            prev.next = node;
            prev = node;
            r = val / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + r;
            ListNode node = new ListNode(val % 10);
            prev.next = node;
            prev = node;
            r = val / 10;
            l2 = l2.next;
        }

        if (r > 0) {
            ListNode node = new ListNode(r);
            prev.next = node;
            prev = node;
        }

        return head;
    }
}
