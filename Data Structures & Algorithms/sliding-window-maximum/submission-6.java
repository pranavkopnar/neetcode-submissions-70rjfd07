class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> {
            int d = b[0] - a[0];
            return d == 0 ? b[1] - a[1] : d;
        });

        int n = nums.length;
        int[] ans = new int[n-k+1];
        int i = 0;
        for (i = 0; i < k; i++) {
            pq.add(new int[]{nums[i], i});
        }

        ans[0] = pq.peek()[0];

        for (i = 1; i <= n-k; i++) {

            pq.add(new int[]{nums[i+k-1], i+k-1});

            int max = pq.peek()[0];
            int ind = pq.peek()[1];

            while (ind < i && !pq.isEmpty()) {
                max = pq.peek()[0];
                ind = pq.peek()[1];
                if (ind < i) pq.poll();
            }

            ans[i] = max;
        }

        return ans;
    }
}
