class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int noi = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, n, m);
                    noi++;
                }
            }
        }

        return noi;
    }

    public void bfs(char[][] grid, int i, int j, int n, int m) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] pair = queue.removeFirst();
            i = pair[0];
            j = pair[1];
            grid[i][j] = '0';

            if (i > 0 && grid[i - 1][j] == '1')
                queue.addLast(new int[] {i - 1, j});
            if (j > 0 && grid[i][j-1] == '1')
                queue.addLast(new int[] {i, j-1});
            if (i < n - 1 && grid[i + 1][j] == '1')
                queue.addLast(new int[] {i + 1, j});
            if (j < m - 1 && grid[i][j + 1] == '1')
                queue.addLast(new int[] {i, j + 1});
        }
    }
}
