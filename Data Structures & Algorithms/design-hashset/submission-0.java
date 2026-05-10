class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int value) {
        this.val = value;
    }
}

class MyHashSet {

    private ListNode[] set;

    public MyHashSet() {
        this.set = new ListNode[10000];
        for (int i=0; i<10000; i++) {
            this.set[i] = new ListNode(0);
        }
    }
    
    public void add(int key) {
        ListNode curr = this.set[key % 10000];
        while (curr.next != null) {
            if (curr.next.val == key) {
                return;
            }
            curr = curr.next;
        }

        curr.next = new ListNode(key);
    }
    
    public void remove(int key) {
        ListNode curr = this.set[key % 10000];
        while (curr.next != null) {
            if (curr.next.val == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        ListNode curr = this.set[key % 10000];
        while (curr.next != null) {
            if (curr.next.val == key) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */