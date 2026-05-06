class Solution {
    private int c = 1;

    public boolean validPalindrome(String s) {
        return palindrome(s, 0 , s.length() - 1);
    }

    public boolean palindrome(String s, int l , int r) {
        if (l < r) {
            if (s.charAt(l) != s.charAt(r) && c > 0) {
                c--;
                return palindrome(s, l+1 , r) || palindrome(s , l, r-1);
            } else if (s.charAt(l) == s.charAt(r)) {
                return palindrome(s, l+1 , r-1);
            } else {
                return false;
            }
        }

        return true;
    } 
}