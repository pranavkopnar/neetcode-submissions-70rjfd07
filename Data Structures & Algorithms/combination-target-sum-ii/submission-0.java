class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        combinationSum2(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    public void combinationSum2(int[] candidates, int target, int s, List<List<Integer>> res, List<Integer> combination) {
        if (target < 0)
            return;
        
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = s; i < candidates.length; i++) {
            if (i > s && candidates[i] == candidates[i-1])
                continue;

            if (candidates[i] > target)
                break;

            combination.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i+1, res, combination);
            combination.remove(combination.size() - 1);
        }
    }
}