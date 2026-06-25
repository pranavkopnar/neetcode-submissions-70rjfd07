class Solution {
    public String minWindow(String s, String t) {
        
        int[] tcnt = new int[128];

        for (char c : t.toCharArray()) {
            tcnt[c]++;
        }


        int l = 0, r = 0, count = t.length();
        int len = Integer.MAX_VALUE, start = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            if (tcnt[c] > 0) count--;
            r++;
            tcnt[c]--;

            while (count == 0) {
                if (len > (r - l)) {
                    len = r - l;
                    start = l;
                }
                char c1 = s.charAt(l);
                l++;
                tcnt[c1]++;
                if (tcnt[c1] > 0) {
                    count++;
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
        

    }
}
