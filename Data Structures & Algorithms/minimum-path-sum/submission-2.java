class Solution {
    public int minPathSum(int[][] grid) {
        

        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n+1];

        for (int j=0; j<n; j++) {
            dp[j+1] = grid[0][j] + dp[j];
        }

        for (int i=1; i<m; i++) {
            dp[0] = Integer.MAX_VALUE;
            for (int j=0; j<n; j++) {
                dp[j+1] = grid[i][j] + Math.min(dp[j+1], dp[j]);
            }
        }

        return dp[n];
    }
}