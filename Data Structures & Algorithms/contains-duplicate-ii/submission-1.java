class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int n = nums.length;
        int l = 0, r = k >= n ? n - 1 : k;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            int i = l;
            int j = l;
            while (j <= r) {
                map.put(nums[j], map.getOrDefault(nums[j],0) + 1);

                if (map.getOrDefault(nums[j], 0) > 1) {
                    return true;
                }
                
                j++;
            }
            map.clear();
            l++;
            r++;
        }

        return false;
    }
}