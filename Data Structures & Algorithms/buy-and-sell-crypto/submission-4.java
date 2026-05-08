class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        int max = -1;

        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            ans = Math.max(ans, max - prices[i]);
        }

        return ans;
    }
}
