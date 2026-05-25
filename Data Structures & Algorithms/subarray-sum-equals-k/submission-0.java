class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            int d = sum - k;
            res += map.getOrDefault(d,0);
            map.put(sum , map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}