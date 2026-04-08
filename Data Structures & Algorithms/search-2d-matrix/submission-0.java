class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int len = m * n;

        int l=0, r=len-1;

        while (l <= r) {
            int mid = (l + r)/2;

            int i = mid/n;
            int j = (mid - (i * n));

            if (target < matrix[i][j]) {
                r = mid-1;
            } else if (target > matrix[i][j]) {
                l = mid+1;
            } else {
                return true;
            }
        }

        return false;
    }
}
