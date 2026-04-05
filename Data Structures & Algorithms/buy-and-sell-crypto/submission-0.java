class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, ans = 0;
        int n = prices.length;
        for (int i=n-1; i>=0; i--) {
            if (max > prices[i]) {
                ans = Math.max(ans,(max - prices[i]));
            }

            max = Math.max(max,prices[i]);
        }

        return ans;
    }
}
