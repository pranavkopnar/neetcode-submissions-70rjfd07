class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinationRec(nums, 0, target, new ArrayList<>());
        return ans;
    }

    public void combinationRec(int[] nums, int i, int target, List<Integer> combination) {
        if (target < 0 || (target > 0 && i == nums.length))
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }

        combination.add(nums[i]);
        combinationRec(nums, i, target - nums[i], combination);

        combination.remove(combination.size() - 1);
        combinationRec(nums, i + 1, target, combination);
    }
}
