class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        int n = arr.length;
        int f = 0;
        int l = 1;
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i+1]) {
                l = f == 1 ? l + 1 : 1;
                f = 2;
            } else if (arr[i] > arr[i+1]) {
                l = f == 2 ? l + 1 : 1;
                f = 1;
            } else {
                l = 0;
                f = 0;
            }

            ans = Math.max(ans, l);
        }

        return ans + 1;
    }
}