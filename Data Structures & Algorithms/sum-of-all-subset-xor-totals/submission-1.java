class Solution {
    int res = 0;

    public int subsetXORSum(int[] nums) {
        recXOR(nums, 0, new ArrayList<>());
        return res;
    }

    public void recXOR(int[] nums, int i, List<Integer> subset) {
        if (i == nums.length) {
            int xor = 0;
            for (int num : subset) {
                xor ^= num;
            }
            res += xor;
            return;
        }

        subset.add(nums[i]);
        recXOR(nums, i + 1, subset);

        subset.remove(subset.size() - 1);
        recXOR(nums, i + 1, subset);
        
    }
}