class MinStack {

    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> min;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if (!min.isEmpty()) {
            if (val < min.getLast()) {
                min.add(val);
            } else {
                min.add(min.getLast());
            }
        } else {
            min.add(val);
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pollLast();
            min.pollLast();
        } 

    }
    
    public int top() {
        return stack.getLast();
       
    }
    
    public int getMin() {
        return min.getLast();
    }
}
