class Solution {
    public String longestPalindrome(String s) {
        int len = 0;
        int ind = 0;
        int n = s.length();
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int l = i, r = j;
                while (l < r && s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                }

                if (l >= r && len < (j-i+1)) {
                    len = j-i+1;
                    ind = i;
                }
            }
        }

        return s.substring(ind, ind + len);
    }
}
