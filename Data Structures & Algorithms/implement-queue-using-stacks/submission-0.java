class MyQueue {

    private Deque<Integer> s1;
    private Deque<Integer> s2;

    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.addLast(s1.removeLast());
        }

        s1.addLast(x);

        while (!s2.isEmpty()) {
            s1.addLast(s2.removeLast());
        }
    }
    
    public int pop() {
        if (s1.isEmpty()) {
            return -1;
        }
        return s1.removeLast();
    }
    
    public int peek() {
        if (s1.isEmpty()) {
            return -1;
        }
        return s1.getLast();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */