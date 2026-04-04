class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] ans = new int[n];

        for (int i=0; i<n; i++) {
            arr1[i] = nums[i];
            if (i > 0) arr1[i] *= arr1[i-1];  
        }

        for (int i=n-1; i>=0; i--) {
            arr2[i] = nums[i];
            if (i < n-1) arr2[i] *= arr2[i+1];  
        }

        for (int i=1; i<n-1; i++) {
            ans[i] = arr1[i-1] * arr2[i+1];
        }

        ans[0] = arr2[1];
        ans[n-1] = arr1[n-2];

        return ans;
    }
}  
