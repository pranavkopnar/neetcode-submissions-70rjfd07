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
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode temp = null;
        return reverse(head, temp);
    }

    private ListNode reverse(ListNode node, ListNode temp) {
        if (node.next == null) {
            node.next = temp;
            return node;
        }

        ListNode next = node.next;
        node.next = temp;
        temp = node;

        return reverse(next, temp);
    }
}
