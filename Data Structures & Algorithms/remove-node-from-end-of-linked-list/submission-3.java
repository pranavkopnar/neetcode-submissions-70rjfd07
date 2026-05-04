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
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        int ind = list.size() - n;
        ListNode node = list.get(ind);

        if (ind == 0) {
            head = node.next;
            node.next = null;
        } else {
            ListNode prev = list.get(ind - 1);
            prev.next = node.next;
            node.next = null;
        }

        return head;
    }
}
