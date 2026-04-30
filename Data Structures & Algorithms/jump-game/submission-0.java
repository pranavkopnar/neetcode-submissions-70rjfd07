class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int i) {
        if (i == nums.length-1) return true;
        else if (i >= nums.length) return false;

        int val = nums[i];
        while (val > 0) {
            boolean ans = dfs(nums, i+val);
            val--;
            if (ans) return true;
        }

        return false;
    }
}
