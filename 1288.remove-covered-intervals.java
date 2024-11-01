import java.util.Arrays;
import java.util.Comparator;

class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int [] a) -> a[0]).thenComparingInt((int [] a) -> -a[1]));
        int elements = intervals.length;
        int envelopStart = intervals[0][0];
        int envelopEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (envelopStart <= intervals[i][0] && envelopEnd >= intervals[i][1]) {
                elements--;
            } else {
                envelopEnd = intervals[i][1];
                envelopStart = intervals[i][0];
            }
        }
        return elements;
    }
}