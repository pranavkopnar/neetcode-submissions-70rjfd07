class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        if (!min.isEmpty()) {
            if (val < min.getLast()) {
                min.addLast(val);
            } else {
                min.addLast(min.getLast());
            }
        } else {
            min.addLast(val);
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.removeLast();
            min.removeLast();
        }

    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return min.getLast();
    }
}
