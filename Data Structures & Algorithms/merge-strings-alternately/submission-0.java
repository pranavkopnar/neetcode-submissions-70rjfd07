class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int l = 0;
        int r = 0;

        StringBuilder str = new StringBuilder();

        while (l < word1.length() && r < word2.length()) {
            str.append(word1.charAt(l));
            str.append(word2.charAt(r));
            l++;
            r++;
        }

        if (l < word1.length()) {
            str.append(word1.substring(l));
        } else if (r < word2.length()) {
            str.append(word2.substring(l));
        }

        return str.toString();

    }
}