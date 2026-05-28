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
    public ListNode mergeKLists(ListNode[] lists) {
        Map<Integer, ListNode> map = new HashMap<>();

        for (ListNode list : lists) {
            while (list != null) {
                ListNode temp = list.next;

                if (map.get(list.val) == null) {
                    map.put(list.val, new ListNode());
                }

                ListNode curr = map.get(list.val);
                while (curr.next != null) {
                    curr = curr.next;
                }

                curr.next = list;
                list.next = null;
                list = temp;
            }
        }

        Queue<Integer> pq = new PriorityQueue<>();

        for (int k : map.keySet()) {
            pq.add(k);
        }

        ListNode dummy = new ListNode();
        ListNode klist = dummy;

        while (!pq.isEmpty()) {
            int key = pq.poll();
            klist.next = map.get(key).next;
            while (klist.next != null) {
                klist = klist.next;
            }
        }

        return dummy.next;
    }
}
