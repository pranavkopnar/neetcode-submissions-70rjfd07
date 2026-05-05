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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode curr = head, start = null;
        int i = 1;

        while (i != left) {
            start = curr;
            curr = curr.next;
            i++;
        }

        ListNode prev = null, first = curr;

        while (i >= left && i <= right) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            i++;
        }

        if (start != null) 
            start.next = prev;

        if (curr != null)
            first.next = curr;

        return left == 1 ? prev : head;
    }
}