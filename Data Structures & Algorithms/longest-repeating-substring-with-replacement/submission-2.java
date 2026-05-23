class Solution {
    public int characterReplacement(String s, int k) {
        

        Map<Character, Integer> map = new HashMap<>();

        int l = 0, r = 0;
        int n = s.length();
        int maxF = 0, ans = 0;

        while (r < n) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c,0) + 1);
            maxF = Math.max(maxF , map.get(c));

            while ((r - l) + 1 - maxF > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            ans = Math.max(ans, (r - l) + 1);
            r++;
        }

        return ans;
    }
}
