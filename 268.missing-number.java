import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class MissingNumber {
  public int missingNumber(int[] nums) {
    ArrayList<Integer> numsArrayList = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
    numsArrayList.add(-1);
    for (int i = 0; i < numsArrayList.size(); ++i){
      // swap
      while (numsArrayList.get(i) != i && numsArrayList.get(i) != -1) {
        int temp = numsArrayList.get(i);
        numsArrayList.set(i, numsArrayList.get(temp));
        numsArrayList.set(temp, temp);
      }
    }
    for (int i = 0; i < numsArrayList.size(); ++i) {
      if (numsArrayList.get(i) == -1){
        return i;
      }
    }
    return -1;
  }
}
