class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 1)
            return new ArrayList<>(Arrays.asList(nums[0]));

        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int c = 1;

        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (c > nums.length / 3) {
                    res.add(nums[i-1]);
                }
                c = 0;
            } 
            c++;
        }

        if (c > nums.length / 3)
            res.add(nums[nums.length-1]);

        return res;
    }
}