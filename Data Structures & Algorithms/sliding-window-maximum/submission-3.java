class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length, l = n-k+1;
        int[] ans = new int[l];
        int max = 0, i = 0, ind = -1;

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));

        while (i < k) {
            pq.add(new int[]{nums[i],i});
            i++;
        }

        ans[0] = pq.peek()[0];

        for (i=1;i<n-k+1;i++) {

            max = pq.peek()[0];
            ind = pq.peek()[1];

            pq.add(new int[]{nums[i+k-1], (i+k-1)});

            if (max <= nums[i+k-1]) {
                ans[i] = nums[i+k-1];
            } else {
                if (ind >= i) {
                    ans[i] = max;
                } else {
                    while(ind < i && !pq.isEmpty()) {
                        max = pq.peek()[0];
                        ind = pq.peek()[1];
                       if (ind < i) pq.poll();
                    }

                    ans[i] = max;
                }
            }
        }

        return ans;
    }
}
