import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CountDays {
  public int countDays(int days, int[][] meetings) {
    Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
    int[] currentArray = meetings[0];
    Integer meetingDays = 0;
    for (int i = 1; i < meetings.length; ++i) {
      if (currentArray[1] >= meetings[i][0]) {
        if (currentArray[1] < meetings[i][1]) {
          currentArray[1] = meetings[i][1];
        }
      } else {
        meetingDays += currentArray[1] - currentArray[0] + 1;
        currentArray = meetings[i];
      }
    }
    meetingDays = currentArray[1] - currentArray[0] + 1;
    return days - meetingDays;
  }
}
