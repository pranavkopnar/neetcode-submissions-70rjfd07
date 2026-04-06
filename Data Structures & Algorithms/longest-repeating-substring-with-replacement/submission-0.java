class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] count = new int[26];
        int ans = 0;
        int i=0,j=0;
        count[s.charAt(i) - 'A'] = 1;
        int n = s.length();
        int total = 0, maxf = 0;

        while(j < n) {
            for (int l=0;l<26;l++) {
                total += count[l];
                maxf = Math.max(maxf,count[l]);
            }

            if ((total - maxf) <= k) {
                ans = Math.max(ans, j-i+1);
                j++;
                if (j < n) count[s.charAt(j) - 'A'] += 1;
            } else {
                count[s.charAt(i) - 'A'] -= 1;
                i++;
            }

            total = 0;
            maxf = 0;
        }

        return ans;
        
    }
}
