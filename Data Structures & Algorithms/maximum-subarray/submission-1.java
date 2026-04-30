class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        int ans = Integer.MIN_VALUE;

        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                if (j-i == 0) {
                    dp[i][j] = nums[i];
                } else if (j - i == 1) {
                    dp[i][j] = nums[i] + nums[j];
                } else {
                    dp[i][j] = nums[i] + nums[j] + dp[i+1][j-1];
                }

                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}
