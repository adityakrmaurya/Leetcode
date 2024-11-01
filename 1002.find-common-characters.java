import java.util.ArrayList;
import java.util.List;

class CommonChars {
  public List<String> generateStringArray(String s) {
    List<String> ss = new ArrayList<>();
    for (var x : s.toCharArray()) {
      ss.add(String.valueOf(x));
    }
    return ss;
  }

  public List<String> commonChars(String[] words) {
    List<String> ss = new ArrayList<>();
    for (int i = 0; i < words.length; ++i) {
      if (i == 0) {
        ss = generateStringArray(words[i]);
      } else {
        ss.retainAll(generateStringArray(words[i]));
      }
    }
    return ss.parallelStream().toList();
  }
}
