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
        return removeNthFromEnd(head, new int[]{n});
    }

    public ListNode removeNthFromEnd(ListNode node, int[] n) {
        if (node == null)
            return null;

        node.next = removeNthFromEnd(node.next, n);
        n[0]--;
        if (n[0] == 0)
            node = node.next;

        return node;
    }
}
