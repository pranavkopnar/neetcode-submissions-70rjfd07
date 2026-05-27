class MyQueue {

    private Deque<Integer> s;

    public MyQueue() {
        s = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (s.isEmpty()) {
            s.addLast(x);
            return;
        }

        int val = s.removeLast();
        push(x);

        s.addLast(val);
        return;
    }
    
    public int pop() {
        return s.removeLast();
    }
    
    public int peek() {
        return s.getLast();
    }
    
    public boolean empty() {
        return s.isEmpty();
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