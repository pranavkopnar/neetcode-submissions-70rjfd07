class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int n = nums.length;
        int ans = nums[0];
        int sum = 0;

        for (int i=0; i<n; i++) {
            sum = 0;
            for (int j=i; j<i+n; j++) {
                sum += nums[j%n];
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}