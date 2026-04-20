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
        ListNode list = head;

        while (list != null) {
            l++;
            list = list.next;
        }

        int m = (l - n) + 1;

        ListNode prev = null, curr = head;
        int c = 1;
        
        while (c <= m) {
            if (c == m) {
                ListNode next = curr.next;
                if (prev != null) prev.next = next;
                curr.next = null;
                return prev != null ? head : next; 
            }

            prev = curr;
            curr = curr.next;
            c++;
        }

        return null;
    }
}
