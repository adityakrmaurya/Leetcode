/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms Easy (40.19%) Likes: 23172 Dislikes: 1630 Total Accepted: 4.2M Total Submissions:
 * 10.4M Testcase Example: '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
 * correct order. Every close bracket has a corresponding open bracket of the same type.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "()" Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "()[]{}" Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(]" Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4 s consists of parentheses only '()[]{}'.
 * 
 * 
 */

// @lc code=start
import java.util.Stack;

class IsValid {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char currentChar : s.toCharArray()) {
      if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
        stack.push(currentChar);
      } else if (!stack.isEmpty() && ((currentChar == ')' && stack.peek() == '(')
          || (currentChar == '}' && stack.peek() == '{')
          || (currentChar == ']' && stack.peek() == '['))) {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }
}

// @lc code=end

