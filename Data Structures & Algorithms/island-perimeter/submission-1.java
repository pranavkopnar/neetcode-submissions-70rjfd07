class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (j == 0 || grid[i][j - 1] != 1)
                        res++;
                    if (i == 0 || grid[i - 1][j] != 1)
                        res++;
                    if (i == n - 1 || grid[i + 1][j] != 1)
                        res++;
                    if (j == m - 1 || grid[i][j + 1] != 1)
                        res++;
                }
            }
        }

        return res;
    }
}