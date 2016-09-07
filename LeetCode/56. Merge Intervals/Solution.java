import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        }
        List<Interval> ans = new ArrayList<>();
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start != 0 ? i1.start - i2.start : i1.end - i2.end);
        Iterator<Interval> iter = intervals.iterator();
        Interval i = iter.next();
        while (iter.hasNext()) {
            Interval next = iter.next();
            if (next.start <= i.end) {
                i.end = Math.max(i.end, next.end);
            } else {
                ans.add(i);
                i = next;
            }
        }
        ans.add(i);
        return ans;
    }
}