import java.util.HashSet;
import java.util.Set;

class SingleNumber {
  public int[] singleNumber(int[] nums) {
    Set<Integer> si = new HashSet<>();
    for (var val : nums) {
      if (si.contains(val)) {
        si.remove(val);
      } else {
        si.add(val);
      }
    }
    return si.stream().mapToInt(Integer::intValue).toArray();
  }
}
