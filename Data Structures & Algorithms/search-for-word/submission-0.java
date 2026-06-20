class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        int[][] visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (exist(board, visit, word, i, j, 0))
                    return true;
            }
        }

        return false;
    }

    public boolean exist(char[][] board, int[][] visit, String word, int i, int j, int k) {
        if (k == word.length())
            return true;

        if (i < 0 || i == board.length || j < 0 || j == board[0].length || visit[i][j] == 1)
            return false;

        boolean isExist = false;

        if (board[i][j] == word.charAt(k)) {
            visit[i][j] = 1;

            isExist = exist(board, visit, word, i - 1, j, k + 1) ||
                    exist(board, visit, word, i + 1, j, k + 1) ||
                    exist(board, visit, word, i, j - 1, k + 1) ||
                    exist(board, visit, word, i, j + 1, k + 1);

            visit[i][j] = 0;
        }

        return isExist;

    }
}