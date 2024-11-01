import java.util.ArrayList;
import java.util.Collections;

class ChalkReplacer {
  public int chalkReplacer(int[] chalk, int k) {
    ArrayList<Integer> cummulativeChalk = new ArrayList<>();
    int cummulativeSum = 0;
    for (int i = 0; i < chalk.length; i++) {
      cummulativeSum += chalk[i];
      cummulativeChalk.set(i, cummulativeSum);
    }
    Integer remaining = k - (k / cummulativeSum) * cummulativeSum;
    Integer location = Collections.binarySearch(cummulativeChalk, remaining);
    
  }
}
