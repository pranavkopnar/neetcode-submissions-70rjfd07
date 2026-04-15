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
    public void reorderList(ListNode head) {
        
        Map<ListNode, ListNode> prevMap = new HashMap<>();
        ListNode curr = head, currPrev = null;

        while (curr != null) {
            prevMap.put(curr,currPrev);
            currPrev = curr;
            curr = curr.next;
        }

        ListNode first = head, last = currPrev;

        while (first.next != null) {
            
            ListNode next = first.next;
            ListNode prev = prevMap.get(last);

            first.next = last;
            last.next = null;

            if (last != next) last.next = next;

            first = next;
            last = prev;

            if (first == last) {
                last.next = null;
                break;
            }

        }
    }
}
