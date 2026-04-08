class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;
        int l = 1;
        int r = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            r = Math.max(r,piles[i]);
        }

        int ans = -1;

        while (l <= r) {
            int m = (l + r)/2;
            int noh = 0;
            for (int i=0; i<n; i++) {
                noh += (piles[i] / m) + ((piles[i] % m) == 0 ? 0 : 1);
            }

            if (noh > h) {
                l = m + 1;
            }else if (noh <= h) {
                ans = m;
                r = m-1;
            }
        }

        return ans;
    }
}
