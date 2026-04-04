class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        int c = 0;
        int max = 0;

        for (int i=0; i<nums.length; i++) {
            if (set.contains(nums[i]) && !set.contains(nums[i]-1)) {
                int n = nums[i];
                while(set.contains(n)) {
                    set.remove(n);
                    n = n+1;
                    c++;
                }

                max = Math.max(max,c);
                c = 0;
            }
        }

        return max;
    }
}
