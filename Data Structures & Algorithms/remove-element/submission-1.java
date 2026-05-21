class Solution {
    public int removeElement(int[] nums, int val) {
        
        int k = 0;
        int i = 0;
        while (i < nums.length) {
            while (i < nums.length && nums[i] == val) {
                i++;
            }

            if (i < nums.length) {
                nums[k] = nums[i];
                i++;
                k++;
            }
        }

        return k;
    }
}