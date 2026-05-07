class MyStack {
    private Deque<Integer> q1;
    private Deque<Integer> q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>(); 
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        int last = 0;
        while (!q1.isEmpty()) {
            last = q1.removeFirst();
            if (!q1.isEmpty())
                q2.add(last);
        }

        while (!q2.isEmpty()) {
            q1.add(q2.removeFirst());
        }

        return last;
    }
    
    public int top() {
        int last = 0;
        while (!q1.isEmpty()) {
            last = q1.removeFirst();
            q2.add(last);
        }

        while (!q2.isEmpty()) {
            q1.add(q2.removeFirst());
        }

        return last;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */