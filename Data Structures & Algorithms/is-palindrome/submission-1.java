class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                str.append(c);
            }
        }

        return str.toString().equalsIgnoreCase(str.reverse().toString());
    }
}
