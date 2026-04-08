class Solution {
    public int search(int[] nums, int target) {
        
        int n = nums.length;
        int l=0,r=n-1;
        int ind = -1;

        while(l <= r) {
            int m = (l+r)/2;
            
            if (target < nums[0]) {
                if (nums[m] >= nums[0] || target > nums[m]) {
                    l = m+1;
                } else if (target < nums[m]) {
                    r = m-1;
                } else {
                    ind = m;
                    break;
                }
            } else {
                if (nums[m] < nums[0] || target < nums[m]) {
                    r = m-1;
                } else if (target > nums[m]) {
                    l = m+1;
                } else {
                    ind = m;
                    break;
                }
            }
            
        }

        return ind;
    }
}
