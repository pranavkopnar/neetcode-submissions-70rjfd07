class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int l = 0, r = 0;
        int[] ans  = new int[2];
        int n = numbers.length;
        r = n-1;

        while (l < r) {
            if ((numbers[l] + numbers[r]) > target) {
                r--;
            } else if ((numbers[l] + numbers[r]) < target) {
                l++;
            } else {
                ans[0] = l+1;
                ans[1] = r+1;
                break;
            }
        }

        return ans;
    }
}
