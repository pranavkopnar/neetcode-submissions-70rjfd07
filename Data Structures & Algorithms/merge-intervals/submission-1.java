class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start;
        int end;
        int i = 0;

        while (i < intervals.length) {
            start = intervals[i][0];
            end = intervals[i][1];

            while (i < intervals.length && intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
                i++;
            }

            res.add(new int[] {start, end});
        }

        return res.toArray(int[][]::new);
    }
}
