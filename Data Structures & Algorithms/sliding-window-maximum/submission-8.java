class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> q = new LinkedList<>();

        int l = 0, r = 0, n = nums.length;
        int[] ans = new int[n-k+1];

        while (r < n) {

            while (!q.isEmpty() && nums[q.getLast()] <= nums[r]) {
                q.removeLast();
            }

            q.addLast(r++);

            if (l > q.getFirst()) {
                q.removeFirst();
            }

            if ((r) >= k) {
                ans[l++] = nums[q.getFirst()];
            }
        }

        return ans;
    }
}
