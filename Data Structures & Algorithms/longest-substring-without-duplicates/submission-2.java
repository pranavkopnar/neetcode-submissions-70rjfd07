class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        int l=0, ans=0;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c,i);
                l++;
            } else {
                ans = Math.max(ans,l);
                int j = map.get(c);
                l = i - j;

                map.clear();
                while(j <= i-1) {
                    map.put(s.charAt(j+1), j+1);
                    j++;
                }
                
            }
        }


        return Math.max(ans,l);
    }
}
