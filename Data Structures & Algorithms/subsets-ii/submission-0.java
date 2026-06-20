class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void subsetsWithDup(List<List<Integer>> res, List<Integer> subset, int[] nums, int i) {
        res.add(new ArrayList<>(subset));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j-1]) 
                continue;

            subset.add(nums[j]);
            subsetsWithDup(res, subset, nums, j+1);
            subset.remove(subset.size() - 1);
        }

    }
}