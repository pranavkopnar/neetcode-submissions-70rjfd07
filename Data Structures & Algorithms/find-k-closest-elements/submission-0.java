class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> nums = new ArrayList<>();

        for (int num : arr) {
            nums.add(num);
        }
        
        nums.sort((a,b) -> {
            int d = Math.abs(a-x) - Math.abs(b-x);
            return d == 0 ? Integer.compare(a,b) : d;
        });

        List<Integer> list = new ArrayList<>();
        int i = 0;

        while (k != 0) {
            list.add(nums.get(i));
            k--;
            i++;
        }

        Collections.sort(list);

        return list;
    }
}