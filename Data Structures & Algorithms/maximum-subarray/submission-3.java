class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int res = nums[n-1];
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];

        for (int i=n-2; i>=0; i--) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i+1]);
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
