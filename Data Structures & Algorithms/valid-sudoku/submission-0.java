class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] flag = new int[9][10];
        int[][] row = new int[9][10];
        int[][] column = new int[9][10];

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                int k = ((i/3) * 3) + j/3;
                int num = board[i][j] - '0';
                if (board[i][j] != '.') {
                    if (flag[k][num] == 1 || row[i][num] == 1 || column[j][num] == 1)
                        return false;
                    flag[k][num] = 1;
                    row[i][num] = 1;
                    column[j][num] = 1;
                }
            }
        }

        return true;
    }
}
