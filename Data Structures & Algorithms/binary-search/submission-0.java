class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l=0, r=n-1;

        while (l <= r) {
            int m = (l + r)/2;

            if (target < nums[m]) {
                r = m-1;
            } else if (target > nums[m]) {
                l = m+1;
            } else {
                return m;
            }

        }

        return -1;
    }
}
