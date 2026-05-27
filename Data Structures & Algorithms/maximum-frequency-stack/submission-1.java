class FreqStack {

    private Map<Integer, Integer> freq;
    private Map<Integer, Deque<Integer>> stacks;
    private int maxf;

    public FreqStack() {
        freq = new HashMap<>();
        stacks = new HashMap<>();
        maxf = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (maxf < freq.get(val)) {
            maxf = freq.get(val);
            stacks.putIfAbsent(maxf, new ArrayDeque<>());
        }

        stacks.get(f).addLast(val);
    }
    
    public int pop() {
        int val = stacks.get(maxf).removeLast();
        freq.put(val , freq.get(val) - 1);
        if (stacks.get(maxf).isEmpty()) 
            maxf--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */