class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        boolean[] added = new boolean[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        permuteUnique(nums, res, new ArrayList<>(), added);
        return res;
    }

    public void permuteUnique(int[] nums, List<List<Integer>> res, List<Integer> permutation, boolean[] added) {

        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (added[i] || (i > 0 && nums[i] == nums[i-1] && !added[i-1]))
                continue;

            permutation.add(nums[i]);
            added[i] = true;
            permuteUnique(nums, res, permutation, added);
            added[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}