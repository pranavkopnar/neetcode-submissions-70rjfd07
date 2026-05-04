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

        int l = 0;
        ListNode curr = head;
        while (curr != null) {
            l++;
            curr = curr.next;
        }

        int m = l - n;
        ListNode prev = null;
        curr = head;
        while (m > 0) {
            prev = curr;
            curr = curr.next;
            m--;
        }

        ListNode node = curr.next;
        if (prev != null) {
            prev.next = curr.next;
        }

        curr.next = null;
        return prev != null ? head : node;
    }
}
