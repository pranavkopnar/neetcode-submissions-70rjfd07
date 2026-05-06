class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 0, k = 0;
        int n = nums.length;

        while (k < n) {
            if (nums[j] == nums[k]) {
                k++;
            } else {
                j = k;
                nums[i++] = nums[k];
            }
        }

        return i;
    }
}