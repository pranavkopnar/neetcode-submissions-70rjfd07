class MyQueue {

    private Deque<Integer> s1;
    private Deque<Integer> s2;

    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        s1.addLast(x);
    }
    
    public int pop() {

        if (!s2.isEmpty()) 
            return s2.removeLast();

        while (!s1.isEmpty()) {
            s2.addLast(s1.removeLast());
        }

        return s2.removeLast();
    }
    
    public int peek() {
        if (!s2.isEmpty()) 
            return s2.getLast();

        while (!s1.isEmpty()) {
            s2.addLast(s1.removeLast());
        }

        return s2.getLast();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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