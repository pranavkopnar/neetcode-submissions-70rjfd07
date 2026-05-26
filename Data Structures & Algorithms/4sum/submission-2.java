class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            while (i > 0 && i < n && nums[i] == nums[i-1]) {
                i++;
            }

            for (int j=i+1; j<n; j++) {
                while (j > i+1 && j < n && nums[j] == nums[j-1]) {
                    j++;
                }

                int l = j+1, r = n-1;

                while (l < r) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[l] + (long)nums[r];  
                    if (sum > (long) target) {
                        r--;
                    } else if (sum < (long) target) {
                        l++;
                    } else {
                        list.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[l],nums[r])));
                        l++;
                        r--;
                        while(l < r && nums[l] == nums[l-1]) {
                            l++;
                        }
                    }
                }
            }
        }

        return list;
    }
}