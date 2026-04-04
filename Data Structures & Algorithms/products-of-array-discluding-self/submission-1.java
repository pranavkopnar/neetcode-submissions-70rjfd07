class Solution {
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        int c = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) product *= nums[i];
            if (nums[i] == 0) c++;
        }

        int[] ans = new int[nums.length];
        if (c > 1) return ans;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0 && c == 0) ans[i] = (int)product/nums[i];
            if (nums[i] == 0) ans[i] = (int)product;
        }
        
        return ans;
    }
}  
