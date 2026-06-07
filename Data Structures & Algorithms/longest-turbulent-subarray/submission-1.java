class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int ans = 1;
        int f = 0;
        int l = 1;

        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i] < arr[i + 1]) {
                    if (f != 1) {
                        l = 1;
                    }

                    f = 1;
                } else if (arr[i] > arr[i + 1]) {
                    if (f != 2) {
                        l = 1;
                    }

                    f = 2;
                } else {
                    l = 0;
                    f = 0;
                }
            } else {
                if (arr[i] > arr[i + 1]) {
                    if (f != 1) {
                        l = 1;
                    }

                    f = 1;
                } else if (arr[i] < arr[i + 1]) {
                    if (f != 2) {
                        l = 1;
                    }

                    f = 2;
                } else {
                    l = 0;
                    f = 0;
                }
            }

            l++;
            ans = Math.max(ans, l);
        }

        return ans;
    }
}