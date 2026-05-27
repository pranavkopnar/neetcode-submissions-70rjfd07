class FreqStack {

    private Map<Integer, Integer> map;
    private List<Integer> list;

    public FreqStack() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
    }
    
    public int pop() {
        int max = Collections.max(map.values());
        int i = list.size() - 1;
        while (i >= 0 && map.get(list.get(i)) != max) {
            i--;
        }

        int val = list.remove(i);
        map.put(val, map.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */