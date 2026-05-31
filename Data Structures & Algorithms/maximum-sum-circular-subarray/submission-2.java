class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int sumMax = 0, sumMin = 0;
        int max = nums[0], min = nums[0];
        int total = 0;

        for (int num : nums) {
            sumMax = Math.max(sumMax + num, num);
            max = Math.max(max, sumMax);
            total += num;
            sumMin = Math.min(sumMin + num, num);
            min = Math.min(min, sumMin);
        }

        return max > 0 ? Math.max(max, total - min) : max;
    }
}