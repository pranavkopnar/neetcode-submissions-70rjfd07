class Solution {
    public int minPathSum(int[][] grid) {
        

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n+1][m+1];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (i == 0) {
                    dp[i+1][j+1] = grid[i][j] + dp[i+1][j];
                    continue;
                }

                if (j == 0) {
                    dp[i+1][j+1] = grid[i][j] + dp[i][j+1];
                    continue;
                }
                
                dp[i+1][j+1] = grid[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
            }
        }

        return dp[n][m];
    }
}