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
    public boolean canAttendMeetings(List<Interval> intervals) {

        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        int e = -1;

        for (Interval interval : intervals) {
            if (interval.start < e) 
                return false;
            e = interval.end;
        }

        return true;

    }
}
