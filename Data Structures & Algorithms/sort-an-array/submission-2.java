class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = (l + r) / 2;

        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);

        merge(nums, l, m, r);
    }

    public void merge(int[] nums, int l, int m, int r) {
        int s1 = m - l + 1;
        int s2 = r - m;

        int[] arr1 = new int[s1];
        int[] arr2 = new int[s2];

        for (int i = l; i <= m; i++) {
            arr1[i - l] = nums[i];
        }

        for (int i = m+1; i <= r; i++) {
            arr2[i - (m + 1)] = nums[i];
        }

        int p = 0;
        int q = 0;
        int k = l;

        while (p < s1 && q < s2) {
            if (arr1[p] <= arr2[q]) {
                nums[l++] = arr1[p++];
            } else {
                nums[l++] = arr2[q++];
            }
        }

        while (p < s1) 
            nums[l++] = arr1[p++];
        
        while (q < s2) 
            nums[l++] = arr2[q++];
   
    }
}