class Solution {
    public int largestRectangleArea(int[] heights) {
        

        int max = 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0; i<=n; i++) {
            while (!stack.isEmpty() && (i == n || heights[i] <= heights[stack.getLast()])) {
                int curr = stack.removeLast();
                max = Math.max(max, heights[curr] * (stack.isEmpty() ? i : i - stack.getLast() - 1));
            }

            stack.addLast(i);
        }

        return max;
    }
}
