class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = prices[0];
        int ans = 0;
        int n = prices.length;

        for (int i=1; i<prices.length; i++) {
            if (prices[i] <= prices[i-1]) {
                ans += prices[i-1] - buy;
                buy = prices[i];
            }
        }

        return ans + prices[n-1] - buy;
    }
}