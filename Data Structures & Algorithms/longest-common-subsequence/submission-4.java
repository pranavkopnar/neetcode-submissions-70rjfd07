class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();

        int[] dp = new int[m+1];
        int d = 0;

        for (int i=0; i<n; i++) {
            d = 0;
            for (int j=0; j<m; j++) {
                int temp = dp[j+1];

                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[j+1] = 1 + d;
                } else {
                    dp[j+1] = Math.max(dp[j+1], dp[j]);
                }

                d = temp;
            }
        }

        return dp[m];
    }
}
