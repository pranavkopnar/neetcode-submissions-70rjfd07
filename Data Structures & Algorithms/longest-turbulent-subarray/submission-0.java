class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int l = 1;

            for (int j = i; j < n - 1; j++) {
                if (j % 2 == 0 && arr[j] < arr[j + 1]) {
                    l++;
                } else if (j % 2 != 0 && arr[j] > arr[j + 1]) {
                    l++;
                } else {
                    break;
                }
            }

            ans = Math.max(ans, l);
            l = 1;

            for (int j = i; j < n - 1; j++) {
                if (j % 2 == 0 && arr[j] > arr[j + 1]) {
                    l++;
                } else if (j % 2 != 0 && arr[j] < arr[j + 1]) {
                    l++;
                } else {
                    break;
                }
            }

            ans = Math.max(ans, l);
        }

        return ans;
    }
}