class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Deque<Integer> stack = new ArrayDeque<>();

        int i = 0;

        while (i < asteroids.length) {
            int num = asteroids[i];

            if (num < 0 && !stack.isEmpty() && stack.getLast() > 0) {
                int temp = stack.removeLast();

                if (temp > Math.abs(num)) {
                    stack.addLast(temp);
                    i++;
                } else if (temp == Math.abs(num)) {
                    i++;
                }
            } else if (num > 0) {
                stack.addLast(num);
                i++;
            } else {
                stack.addLast(num);
                i++;
            }
        }

        int n = stack.size();
        int[] ans = new int[n];
        i = 0;

        while (!stack.isEmpty()) {
            ans[i++] = stack.removeFirst();
        }

        return ans;
    }
}