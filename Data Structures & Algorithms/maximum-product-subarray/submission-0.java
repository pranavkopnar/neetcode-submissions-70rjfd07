class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int l = i, r = j;
                int product = 1;
                while (l <= r) {
                    product *= nums[l];
                    l++;
                }

                max = Math.max(max, product);
            }
        }

        return max;
    }
}
