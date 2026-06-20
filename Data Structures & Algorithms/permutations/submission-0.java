class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, res, new ArrayList<>());
        return res;
    }

    public void permute(int[] nums, List<List<Integer>> res, List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i]))
                continue;

            permutation.add(nums[i]);
            permute(nums, res, permutation);
            permutation.remove(permutation.size() - 1);
        }
    
    }


}