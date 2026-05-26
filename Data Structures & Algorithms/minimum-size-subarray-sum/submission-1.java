class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
        int l = 0, r = 0;
        int len = n+1, sum = 0;

        while (r < n) {
            sum += nums[r];
            while (sum >= target) {
                len = Math.min(len, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }

        return len == n+1 ? 0 : len;
    }
}