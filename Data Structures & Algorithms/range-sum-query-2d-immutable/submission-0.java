class NumMatrix {

    private int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        sumMatrix = new int[n][m];

        sumMatrix[0][0] = matrix[0][0];
        for (int j=1; j<m; j++) {
            sumMatrix[0][j] = matrix[0][j] + sumMatrix[0][j-1];
        }

        for (int i=1; i<n; i++) {
            sumMatrix[i][0] = matrix[i][0] + sumMatrix[i-1][0];
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                sumMatrix[i][j] = matrix[i][j] + sumMatrix[i][j-1] + sumMatrix[i-1][j] - sumMatrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum1 = sumMatrix[row2][col2];
        int sum2 = col1 > 0 ? sumMatrix[row2][col1-1] : 0;
        int sum3 = row1 > 0 ? sumMatrix[row1-1][col2] : 0;
        int sum4 = sum1 - sum2 - sum3;
        
        return (row1 > 0 && col1 > 0) ? sum4 + sumMatrix[row1-1][col1-1] : sum4;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */