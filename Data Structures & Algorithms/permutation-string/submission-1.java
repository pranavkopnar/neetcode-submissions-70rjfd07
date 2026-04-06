class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length(); 

        if (n > m) return false;

        int[] counts1 = new int[26];
        int[] counts2 = new int[26];

        for (int i=0; i<n; i++) {
            counts1[s1.charAt(i)-'a']++;
            counts2[s2.charAt(i)-'a']++;
        }

        int l = 0, r = n;
        int counts = 0;

        for (int i=0;i<26;i++) {
            if (counts1[i] == counts2[i]) counts++;
        }

        
        while (r < m) {
            if (counts == 26) return true;
            
            int ind = s2.charAt(r)-'a';
            counts2[ind]++;
            if (counts1[ind] == counts2[ind]) counts++;
            else if(counts1[ind] == counts2[ind]-1) counts--;

            ind = s2.charAt(l)-'a';
            counts2[ind]--;
            if (counts1[ind] == counts2[ind]) counts++;
            else if (counts1[ind] == counts2[ind]+1) counts--;

            l++;
            r++;
        }

        return counts == 26;
    }
}
