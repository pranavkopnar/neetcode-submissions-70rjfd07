class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    public void combine(List<List<Integer>> res, List<Integer> combination, int n, int k, int s) {
        if (combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = s; i <= n; i++) {
            combination.add(i);
            combine(res, combination, n, k, i+1);
            combination.remove(combination.size() - 1);
        }
    }
}