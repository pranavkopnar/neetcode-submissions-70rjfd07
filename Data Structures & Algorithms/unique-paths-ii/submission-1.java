class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n+1][m+1];

        dp[0][1] = 1;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j];
                } else {
                    dp[i+1][j+1] = 0;
                }
            }
        }

        return dp[n][m];
    }
}