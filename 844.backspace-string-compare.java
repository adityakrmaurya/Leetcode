// This is stack based approach
// The question was made to be solved using two pointers but i find it much easy to understand.
import java.util.Stack;

class BackspaceCompare {
  public int editorString(String s) {
    Stack<Character> sc = new Stack<>();
    int start = 0;
    while (start < s.length()) {
      Character c = s.charAt(start++);
      if (c != '#') {
        sc.push(c);
      } else if (!sc.isEmpty()) {
        sc.pop();
      }
    }
    // System.out.println(sc.toString());
    return sc.hashCode();
  }

  public boolean backspaceCompare(String s, String t) {
    return editorString(s) == editorString(t);
  }
}
