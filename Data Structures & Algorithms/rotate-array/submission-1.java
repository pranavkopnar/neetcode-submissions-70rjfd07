class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }

    public void reverse(int[] nums, int i, int j) {
        if (i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            reverse(nums, i+1, j-1);
        }
    }
}