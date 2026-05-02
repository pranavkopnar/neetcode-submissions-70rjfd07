class Solution {
    Map<Integer, Integer> map;
    public int coinChange(int[] coins, int amount) {
        map = new HashMap<>();
        int ans = minNoOfCoins(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int minNoOfCoins(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (map.containsKey(amount))
            return map.get(amount);


        int res = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int ans = minNoOfCoins(coins, amount - coins[i]);
                if (ans != Integer.MAX_VALUE)
                    res = Math.min(res, 1 + ans);
            }
        }


        map.put(amount, res);
        return res;
    }
}
