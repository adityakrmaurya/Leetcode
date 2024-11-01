class MakeFancyString {
  public String makeFancyString(String s) {
    if (s.length() < 3) return s;
    char secondLast = s.charAt(0);
    char last = s.charAt(1);
    StringBuilder ans = new StringBuilder(s.substring(0, 2));
    for (int i = 2; i < s.length(); ++i) {
      char curr = s.charAt(i);
      if (!(curr == secondLast && curr == last)) {
        ans.append(curr);
      }
      secondLast = last;
      last = curr;
    }
    return ans.toString();
  }
}
