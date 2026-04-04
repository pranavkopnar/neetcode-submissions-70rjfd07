class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        int[] ans = new int[k];
        int i=0;
        while(k != 0) {
            ans[i++] = pq.poll();
            k--;
        }

        return ans;
    }
}
