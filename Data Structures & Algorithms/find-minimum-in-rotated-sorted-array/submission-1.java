class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int l = 0, r = n-1;
        int ans = Integer.MAX_VALUE;

        while (l <= r) {
            int m = (l+r)/2;
            ans = Math.min(ans,nums[m]);
            if (nums[m] <= nums[n-1]) {
                r = m-1;
            } else if (nums[m] >= nums[0]) {
                l = m+1;
            }
        }

        return ans;
    }
}
