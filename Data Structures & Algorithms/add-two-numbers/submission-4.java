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
        
        ListNode l3 = null, prev = null;
        int r = 0;
        while (l1 != null || l2 != null || r != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int val = (val1 + val2 + r) % 10;
            r = (val1 + val2 + r) / 10;
            ListNode node = new ListNode(val);

            if (l3 == null)
                l3 = node;
            if (prev != null)
                prev.next = node;
            prev = node;    

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return l3;
    }
}
