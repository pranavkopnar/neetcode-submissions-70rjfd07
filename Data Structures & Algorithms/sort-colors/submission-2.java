class Solution {
    public void sortColors(int[] nums) {
        
        int n = nums.length;
        int l = 0, i = 0, r = n-1;

        while (i <= r) {
            if (nums[i] == 0) {
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                i++;
                l++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                int temp = nums[r];
                nums[r] = nums[i];
                nums[i] = temp;
                r--;
            }
        }


    }
}