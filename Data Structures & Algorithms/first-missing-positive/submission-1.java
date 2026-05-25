class Solution {
    public int firstMissingPositive(int[] nums) {
        
        Arrays.sort(nums);
        int ans = 1;

        for (int num : nums) {
            if (num > 0 && ans == num) {
                ans++;
            }
        }
        
        return ans;
    }
}