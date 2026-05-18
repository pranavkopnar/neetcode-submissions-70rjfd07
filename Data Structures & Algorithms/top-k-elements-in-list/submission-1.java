class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] ans = new int[k];

        for (int i=0; i<k; i++) {
            int max = 0;
            int num = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    num = entry.getKey();
                }
            }

            ans[i] = num;
            map.remove(num);
        }

        return ans;
    }
}
