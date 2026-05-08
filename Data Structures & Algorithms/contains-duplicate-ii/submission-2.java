class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();
        int l = 0;
        int n = nums.length;

        for (int r = 0; r < n; r++) {
            if (r - l > k) {
                set.remove(nums[l]);
                l++;
            }

            if (set.contains(nums[r])) {
                return true;
            }

            set.add(nums[r]);
        }

        return false;
    }
}