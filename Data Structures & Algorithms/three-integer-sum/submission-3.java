class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int i=0; i<n; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    List<Integer> list = Arrays.asList(nums[l], nums[r], nums[i]);
                    ans.add(list);
                    l++;
                    r--;
                    while (l < r && nums[r] == nums[r+1]) {
                        r--;
                    }
                }
            }
        }

        return ans;
    }
}
