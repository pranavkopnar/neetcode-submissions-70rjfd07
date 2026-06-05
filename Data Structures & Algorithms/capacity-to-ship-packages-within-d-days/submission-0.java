class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int minWeight = Arrays.stream(weights).max().getAsInt();
        int maxWeight = Arrays.stream(weights).sum();

        int l = minWeight;
        int r = maxWeight;

        int ships = 0;

        while (l <= r) {
            int m = (l + r) / 2;

            if (canShip(weights, days, m)) {
                ships = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ships;

    }

    public boolean canShip(int[] weights, int days, int limit) {

        int ships = 1;
        int capacity = limit;

        for (int i = 0; i < weights.length; i++) {
            if (capacity - weights[i] < 0) {
                capacity = limit;
                ships++;
                if (ships > days)
                    return false;
            }

            capacity -= weights[i];
        }

        return true;

    }
}