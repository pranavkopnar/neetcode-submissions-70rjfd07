/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null)
            return null;
        
        Node curr = head;
        while (curr != null) {
            Node node = new Node(curr.val);
            Node temp = curr.next;
            curr.next = node;
            node.next = temp;
            curr = temp;
        }

        curr = head;
        while (curr != null) {
            Node node = curr.next;

            if (curr.random != null) {
                node.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        Node newHead = head.next, prev = null;
        curr = head;
        while (curr != null) {
            Node node = curr.next;
            Node temp = curr.next.next;
            curr.next = temp;
            if (prev != null) {
                prev.next = node;
            }
            prev = node;
            curr = temp;
        }

        return newHead;
    }
}
