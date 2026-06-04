/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        List<Integer> list = new ArrayList<>();

        for (Interval interval : intervals) {
            if (list.isEmpty())
                list.add(Integer.valueOf(interval.end));
            else {
                int f = 0;
                for (Integer end : list) {
                    if (end <= interval.start) {
                        list.remove(end);
                        list.add(Integer.valueOf(interval.end));
                        f = 1;
                        break;
                    }
                }
                
                if (f == 0)
                    list.add(Integer.valueOf(interval.end));
            }
        }

        return list.size();
    }
}
