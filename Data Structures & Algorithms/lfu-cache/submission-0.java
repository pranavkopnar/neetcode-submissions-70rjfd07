class LFUCache {

    private class Node {
        private int key;
        private int value;
        private int feq;
        private Node next;
        private Node prev;

        private Node(int key, int val) {
            this.key = key;
            this.value = val;
        } 
    }

    private class List {

        private Node head;
        private Node tail;
        private int size;

        private List() {
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            this.head.next = this.tail;
            this.tail.prev = this.head;
            this.size = 0;
        }

        private void add(Node node) {
            Node prev = this.tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = this.tail;
            this.tail.prev = node;
            this.size++;
        }

        private void remove(Node node) {
            Node next = node.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;
            this.size--;
        }
    }


    private int capacity;
    private Map<Integer, Node> cache;
    private Map<Integer, List> freqMap;
    private int minFeq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.minFeq = 1;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        Node node = cache.get(key);
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
       
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            Node node = new Node(key, value);
            node.feq = 1;
            cache.put(key, node);
            freqMap.computeIfAbsent(node.feq, k -> new List()).add(node);

            if (cache.size() > capacity) {
                List list = freqMap.get(minFeq);
                Node nodeLFU = list.head.next;
                list.remove(list.head.next);
                cache.remove(nodeLFU.key);
            }

            minFeq = 1;
        }
    }

    public void updateFrequency(Node node) {

        List list = freqMap.get(node.feq);
        list.remove(node);

        if (node.feq == minFeq && list.size == 0) minFeq++;
        
        node.feq++;
        freqMap.computeIfAbsent(node.feq, k -> new List()).add(node);

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */