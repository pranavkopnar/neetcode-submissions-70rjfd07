class Solution {
    public int subsetXORSum(int[] nums) {
        return recXOR(nums, 0, 0);
    }

    public int recXOR(int[] nums, int i, int total) {
        if (i == nums.length)
            return total;

        return recXOR(nums, i + 1, total ^ nums[i]) + recXOR(nums, i + 1, total);
    }
}