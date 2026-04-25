class Solution {
    private int[][] memo;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        memo = new int[2][nums.length];

        Arrays.stream(memo).forEach((row) -> Arrays.fill(row,-1));

        return Math.max(dfs(nums,0,true), dfs(nums,1,false));
    }

    public int dfs(int[] nums, int i, boolean flag) {
        if (flag && i == nums.length-1 || i >= nums.length) return 0;

        if (flag && memo[0][i] != -1) return memo[0][i];
        else if (!flag && memo[1][i] != -1) return memo[1][i];

        if (flag) {
            return memo[0][i] = Math.max(dfs(nums, i+1, flag), nums[i] + dfs(nums, i+2, flag));
        } 
            
        return memo[1][i] = Math.max(dfs(nums, i+1, flag), nums[i] + dfs(nums, i+2, flag));
        
    }
}
