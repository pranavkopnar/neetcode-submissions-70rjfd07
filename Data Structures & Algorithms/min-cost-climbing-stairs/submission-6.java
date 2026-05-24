class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int a = 0;
        int b = 0;

        for (int i=0; i<cost.length; i++) {
                int temp = cost[i] + Math.min(a, b);
                a = b;
                b = temp;
        }


        return Math.min(a, b);
    }
}
