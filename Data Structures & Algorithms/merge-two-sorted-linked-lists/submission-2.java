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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        
        ListNode head = null;

        if (list1 == null) head = list2;
        else if (list2 == null) head = list1;
        else if (list1.val <= list2.val) head = list1;
        else head = list2;

        ListNode prev1 = null, prev2 = null;

        while (list1 != null && list2 != null) {
            prev1 = null;
            prev2 = null;

            while (list1 != null && list1.val <= list2.val) {
                prev1 = list1;
                list1 = list1.next;
            }

            if (prev1 != null) {
                prev1.next = list2;
                continue;
            }
            

            while (list2 != null && list2.val < list1.val) {
                prev2 = list2;
                list2 = list2.next;
            }

            if (prev2 != null) prev2.next = list1;
        }

        return head;
    }
}