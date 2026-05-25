class Solution {
    public int countSubstrings(String s) {
        int c = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                if (s.charAt(i) == s.charAt(j) && ((j-i) <= 2 || dp[i+1][j-1])) {
                    c++;
                    dp[i][j] = true;
                }
            }
        }

        return c;
    }
}
