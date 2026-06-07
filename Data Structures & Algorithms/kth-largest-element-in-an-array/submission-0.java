class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        Queue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        int n = nums.length;

        while (i < n) {
            pq.add(nums[i]);
            i++;

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }
}
