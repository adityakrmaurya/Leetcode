import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Insert {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> merged = new ArrayList<>();
    List<int[]> arrayListIntervals = new ArrayList<>(Arrays.asList(intervals));
    int insertionPoint =
        Arrays.binarySearch(intervals, newInterval, Comparator.comparingInt(a -> a[0]));
    int insertionLocation = insertionPoint > 0 ? insertionPoint : -1 * (insertionPoint + 1);

    if (insertionLocation < 0) {
      insertionLocation = 0;
    }

    arrayListIntervals.add(insertionLocation, newInterval);
    for (int[] interval : arrayListIntervals) {
      if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
        merged.add(interval);
      } else {
        var lastPair = merged.get(merged.size() - 1);
        lastPair[1] = Integer.max(lastPair[1], interval[1]);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }
}
