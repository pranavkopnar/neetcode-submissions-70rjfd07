class Solution {
    public String minWindow(String s, String t) {
        
        int m = t.length();
        int n = s.length();
        int[] tcount = new int[128];

        for (char c : t.toCharArray()) {
            tcount[c]++;
        }


        int l=0,r=0,len=Integer.MAX_VALUE,start=0,count = m;

        while (r < n) {
            char ind1 = s.charAt(r);
            if (tcount[ind1] > 0) count--;
            tcount[ind1]--;
            r++;
            
            while(count == 0) {
                if (len > (r-l)) {
                    len = r - l;
                    start = l;
                }
                char ind2 = s.charAt(l);
                tcount[ind2]++;
                if (tcount[ind2] > 0) count++;
                l++;
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
