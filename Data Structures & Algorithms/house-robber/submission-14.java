class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, 0, memo);
    }

    public int rob(int[] nums, int i, int[] memo) {

        if (i >= nums.length)
            return 0;

        if (memo[i] != -1)
            return memo[i];

        return memo[i] = Math.max(nums[i] + rob(nums, i+2, memo), rob(nums, i+1, memo));
    }
}
