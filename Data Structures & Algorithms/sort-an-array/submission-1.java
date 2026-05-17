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
        mergeSort(nums, m+1, r);

        merge(nums, l, m, r);
    }

    public void merge(int[] nums, int l, int m, int r) {

        int[] mergedArr = new int[r-l+1];

        int i = l;
        int j = m+1;
        int k = 0;

        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                mergedArr[k++] = nums[i++]; 
            } else {
                mergedArr[k++] = nums[j++];
            }
        }

        while (i <= m) {
            mergedArr[k++] = nums[i++];
        }

        while (j <= r) {
            mergedArr[k++] = nums[j++];
        }

        k = l;
        i = 0;

        while (k <= r) {
            nums[k++] = mergedArr[i++];
        }

    }
}