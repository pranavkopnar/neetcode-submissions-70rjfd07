class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        
        int i = 0;

        while (i < n) {

            if (nums[i] > 0) {
                int ind = nums[i] - 1;
                if (ind < n && nums[ind] != nums[i]) {
                    int temp = nums[ind];
                    nums[ind] = nums[i];
                    nums[i] = temp;
                    continue;
                }
            }

            i++;
        }

        int ans = 1;

        for (i = 0; i < n; i++) {
            if (nums[i] != ans)
                break;
            ans++;
        }

        return ans;
    }
}