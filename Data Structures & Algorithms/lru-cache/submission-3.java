class Node {
    private int[] pair;
    private Node prev;
    private Node next;

    public Node(int[] pair) {
        this.pair = pair;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(new int[]{0,0});
        this.tail = new Node(new int[]{0,0});
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }

    private void insert(Node node) {
        Node prev = this.tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.tail;
        this.tail.prev = node;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.pair[1];
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node newNode = new Node(new int[]{key, value});
        map.put(key, newNode);
        insert(newNode);

        if (map.size() > capacity) {
            Node node = this.head.next;
            remove(node);
            map.remove(node.pair[0]);
        }
    }
}
