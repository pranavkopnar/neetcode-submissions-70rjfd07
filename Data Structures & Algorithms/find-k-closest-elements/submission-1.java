class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        int l = 0, r = n-1;

        while ((r - l + 1) > k) {
            int d1 = Math.abs(x - arr[l]);
            int d2 = Math.abs(x - arr[r]);

            if (d1 <= d2) {
                r--;
            } else if (d1 > d2) {
                l++;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            list.add(arr[i]);
        }

        return list;
    }
}