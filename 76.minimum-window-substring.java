import java.util.HashMap;

class MinWindow {
  public String minWindow(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }
    HashMap<Character, Integer> required = new HashMap<>();
    // Creating required hash map
    for (int i = 0; i < t.length(); ++i) {
      if (required.containsKey(t.charAt(i))) {
        required.replace(t.charAt(i), required.get(t.charAt(i)) + 1);
      } else {
        required.put(t.charAt(i), 1);
      }
    }
    // Stores no of charters in t.
    int need = required.size();
    // HashMap for the window
    HashMap<Character, Integer> window = new HashMap<>();
    // Values for window start and end.
    int start = 0;
    int end = 0;
    // Store count of character of t present in window.
    int have = window.size();
    // Stores values for smallest window length
    int smallestStart = 0;
    int smallestEnd = 0;
    int smallestLength = Integer.MAX_VALUE;
    // Sliding Window.
    while (end < s.length()) {
      // Current Character.
      Character curr = s.charAt(end++);
      // Checks if the current charter is one of the character which is present in t.
      if (required.containsKey(curr)) {
        window.put(curr, window.getOrDefault(curr, 0) + 1);
        if (window.getOrDefault(curr, 0) >= required.get(curr)) {
          have++;
        }
      }
      // Check if have and need values are same.
      while (have == need) {
        System.out.println("start, end" + s.charAt(start) + " " + s.charAt(end - 1));
        System.out.println("have" + have + " need" + need);
        System.out.println("smallestLength end-start + 1" + smallestLength + " " + (end - start + 1));
        if (smallestLength > end - start + 1) {
          smallestLength = end - start + 1;
          smallestStart = start;
          smallestEnd = end;
        }
        // Compress window from left side.
        Character removedCharacter = s.charAt(start++);
        if (window.containsKey(removedCharacter) && window.get(removedCharacter) > 1) {
          window.put(removedCharacter, window.get(removedCharacter) - 1);
        } else {
          window.remove(removedCharacter);
        }
        System.out.println(required.containsKey(removedCharacter) + " " + window.getOrDefault(removedCharacter, 0) + " " + required.get(removedCharacter));
        if (required.containsKey(removedCharacter) && window.getOrDefault(removedCharacter, 0) < required.get(removedCharacter)) {
          System.out.println("HAVe" + have);
          have--;
        }
      }
    }
    return smallestLength < Integer.MAX_VALUE ? s.substring(smallestStart, smallestEnd) : "";
  }
}
