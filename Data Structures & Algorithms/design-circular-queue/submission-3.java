class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

class MyCircularQueue {

    private int capacity;
    private Node head;
    private Node tail;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.head = new Node(0);
        this.tail = new Node(0);
    }
    
    public boolean enQueue(int value) {

        if (isFull())
            return false;
 
        
        Node node = new Node(value);
        this.capacity--;

        if (isEmpty()) {
            this.head.next = node;
            this.tail.next = node;
        } else {
            this.tail.next.next = node;
            this.tail.next = node;
        }

        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty())
            return false;

        this.capacity++;
        this.head.next = this.head.next.next;
        if (this.head.next == null) {
            this.tail.next = null;
        }

        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : this.head.next.val;
    }
    
    public int Rear() {
        return isEmpty() ? -1 : this.tail.next.val;
    }
    
    public boolean isEmpty() {
        return this.head.next == null;
    }
    
    public boolean isFull() {
        return this.capacity == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */