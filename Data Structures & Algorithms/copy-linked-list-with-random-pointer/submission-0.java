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
        
        Node itr = head, prev = null, newHead = null;
        Map<Node, Node> map = new HashMap<>();

        while (itr != null) {
            Node newNode = new Node(itr.val);
            newNode.next = null;
            newNode.random = null;
            
            map.put(itr,newNode);
            
            if (prev != null) prev.next = newNode;
            if (prev == null) newHead = newNode;
            
            prev = newNode;
            itr = itr.next;
        }

        Node itr1 = head;
        Node itr2 = newHead;

        while (itr1 != null) {
            Node random = itr1.random;

            if (random != null) {
                itr2.random = map.get(random);
            }

            itr1 = itr1.next;
            itr2 = itr2.next;
        }

        return newHead;

    }
}
