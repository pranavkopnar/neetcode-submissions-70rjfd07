class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String prefix = strs[0];
        for (int i=1; i<strs.length; i++) {
            String curr = strs[i];
            int j = 0;
            while (j < curr.length() && j < prefix.length() &&
                curr.charAt(j) == prefix.charAt(j)) {
                j++;
            }

            prefix = curr.substring(0, j);
        }

        return prefix;
    }
}