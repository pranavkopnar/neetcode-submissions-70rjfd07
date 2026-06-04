class Solution {
    public int numIslands(char[][] grid) {
        

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != 1 && grid[i][j] == '1') {
                    dfs(grid, visited, i, j, n, m);
                    c++;
                } 
            }
        }

        return c;
    }

    public void dfs(char[][] grid, int[][] visited, int i, int j, int n, int m) {

        if (grid[i][j] == '0' || visited[i][j] == 1) {
            return;
        }

        visited[i][j] = 1;

        if (i < n-1)
            dfs(grid, visited, i+1, j, n, m);
        if (j < m-1)
            dfs(grid, visited, i, j+1, n, m);
        if (i > 0) 
            dfs(grid, visited, i-1, j, n, m);
        if (j > 0)
            dfs(grid, visited, i, j-1, n, m);

    }
}
