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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode curr = head;
        ListNode next = curr.next;

        while (curr != null && next != null) {
            int a = curr.val;
            int b = next.val;
            int c = findGCD(a, b);

            ListNode node = new ListNode(c);

            curr.next = node;
            node.next = next;
            curr = next;
            next = next.next;
        }

        return head;
    }

    public int findGCD(int a, int b) {
        if (b == 0)
            return a;

        return findGCD(b, a % b);
    }
}