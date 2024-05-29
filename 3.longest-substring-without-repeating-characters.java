/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

import java.util.HashMap;

class LengthOfLongestSubstring {
  public static int lengthOfLongestSubstring(String s) {
    int start = 0;
    int end = 0;
    int windowSize = 0;
    int maxLength = 0;
    HashMap<Character, Integer> hm = new HashMap<>();
    for (start = 0; start < s.length() && end < s.length(); ++start) {
      while ((end < s.length()) && !hm.containsKey(s.charAt(end))) {
        hm.put(s.charAt(end), 1);
        windowSize++;
        if (maxLength < windowSize) {
          maxLength = windowSize;
        }
        ++end;
      }
      if (end < s.length()) {
        int newStart = s.indexOf(s.charAt(end), start);
        for (int j = start; j <= newStart; ++j) {
          hm.remove(s.charAt(j));
        }
        start = newStart;
        windowSize = end - start - 1;
      }
    }
    return maxLength;
  }
}
// @lc code=end
