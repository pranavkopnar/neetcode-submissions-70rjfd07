class ListNode {
    public int val;
    public int key;
    public ListNode next;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class MyHashMap {

    private ListNode[] map;

    public MyHashMap() {
        this.map = new ListNode[10000];
        for (int i=0; i<10000; i++) {
            this.map[i] = new ListNode(0,0);
        }
    }
    
    public void put(int key, int value) {
        ListNode curr = this.map[key % 10000];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key, value);
    }
    
    public int get(int key) {
        ListNode curr = this.map[key % 10000];
        while (curr.next != null) {
            if (curr.next.key == key) {
                return curr.next.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        ListNode curr = this.map[key % 10000];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */