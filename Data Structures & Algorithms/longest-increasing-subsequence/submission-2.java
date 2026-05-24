class Solution {
    
    private int[][] memo;

    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;

        memo = new int[n][n];

        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return dfs(nums, -1, 0);
    }

    public int dfs(int[] nums, int j, int i) {
        if (i == nums.length) {
            return 0;
        }

        if (j != -1 && memo[i][j] != -1) {
            return memo[i][j];
        }

        int lis = dfs(nums, j, i+1);

        if (j == -1 || nums[i] > nums[j]) {
            lis = Math.max(lis, 1 + dfs(nums, i, i+1));
        }

        if (j != -1) {
            memo[i][j] = lis;
        }

        return lis;
    }
}
