class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsetDFS(nums, 0, new ArrayList<>());
        return ans;
    }

    public void subsetDFS(int[] nums, int i, List<Integer> subset) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        subsetDFS(nums, i + 1, subset);

        subset.remove(subset.size() - 1);
        subsetDFS(nums, i + 1, subset);

    }
}
