class Solution {
    public int countSubstrings(String s) {
        int c = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                if ((j-i) <= 2 && s.charAt(i) == s.charAt(j)) {
                    c++;
                    dp[i][j] = true;
                } else if ((j - i) > 2 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                    if (dp[i][j] == true) c++;
                } 
            }
        }

        return c;
    }
}
