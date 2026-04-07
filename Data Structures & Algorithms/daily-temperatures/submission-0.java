class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] res = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.add(0);

        for (int i=1; i<n; i++) {
            if (temperatures[i] <= temperatures[i-1]) {
                stack.add(i);
            } else {
                while(!stack.isEmpty() && temperatures[stack.getLast()] < temperatures[i]) {
                    res[stack.getLast()] = i - stack.getLast();
                    stack.pollLast();
                }

                stack.add(i);
            }
        }


        return res;

    }
}
