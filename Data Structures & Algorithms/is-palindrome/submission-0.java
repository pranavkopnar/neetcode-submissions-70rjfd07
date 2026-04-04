class Solution {
    public boolean isPalindrome(String s) {
        int i= 0;
        int j = s.length() - 1;

        while(i < j) {
            String str1 = String.valueOf(s.charAt(i));
            String str2 = String.valueOf(s.charAt(j));

            if(str1.matches("[a-zA-Z0-9]") && str2.matches("[a-zA-Z0-9]")) {
                if (!str1.equalsIgnoreCase(str2)) return false;
                i++;
                j--;
            } else if (!str1.matches("[a-zA-Z0-9]")) {
                i++;
            } else if (!str2.matches("[a-zA-Z0-9]")) {
                j--;
            } else {
                i++;
                j--;
            }
        } 

        return true;
    }
}
