import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// WIP
class SortColors {
  public void sortColors(int[] nums) {
    List<Integer> arrayList = new ArrayList<>();
    arrayList.add(0);
    arrayList.add(0);
    arrayList.add(0);
    for (var x : nums) {
      if (0 == x) {
        arrayList.set(0, arrayList.get(0) + 1);
      } else if (1 == x) {
//        arrayList.set()
      }
    }
  }
}