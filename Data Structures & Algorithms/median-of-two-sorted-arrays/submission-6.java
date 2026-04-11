class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length, m = nums2.length;

        if ( n == 0 && m == 0) return -1;

        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        if (total % 2 == 0) {
            if (n == 0) {
                return total > 1 ? ((nums2[half-1] + nums2[half]) / 2.0) : nums2[half-1];
            } else if (m == 0) {
                return total > 1 ? ((nums1[half-1] + nums1[half]) / 2.0) : nums1[half-1];
            }
        } else {
            if (n == 0) return nums2[half-1];
            else if(m == 0) return nums1[half-1];
        }

        int l = 0, r = n-1;

        while (l <= r) {
            int i = (l + r)/2;
            int j = half - (i+2);

            int left1 = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
            int left2 = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
            int right1 = i < n-1 ? nums1[i+1] : Integer.MAX_VALUE;
            int right2 = j < m-1 ? nums2[j+1] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 != 0) return Math.max(left1, left2);
                return (Math.max(left1,left2) + Math.min(right1,right2)) / 2.0;
            }

            if (left1 < right2) {
                l = i + 1;
            } else {
                r = i - 1;
            }
        }

        return -1;
    }
}
