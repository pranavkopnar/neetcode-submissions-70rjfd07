class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            if (!stack.isEmpty() && heights[i] < heights[stack.getLast()]) {
                int curr = heights[stack.getLast()];
                while (!stack.isEmpty() && heights[i] < curr) {
                    stack.removeLast();
                    if (!stack.isEmpty()) {
                        max = Math.max(max, curr * (i - stack.getLast() - 1));
                        curr = heights[stack.getLast()];
                    } else
                        max = Math.max(max, curr * i);
                }
            }

            stack.addLast(i);
        }

        int n = heights.length;

        while (!stack.isEmpty()) {
            int curr = heights[stack.removeLast()];
            if (!stack.isEmpty())
                max = Math.max(max, curr * (n - stack.getLast() - 1));
            else
                max = Math.max(max, curr * n);
        }

        return max;
    }
}
