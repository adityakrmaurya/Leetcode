class AppendCharacters {
  public int appendCharacters(String s, String t) {
    int sp = 0;
    int tp = 0;
    for (sp = 0; sp < s.length() && tp < t.length(); sp++) {
      if (s.charAt(sp) == t.charAt(tp)) {
        ++tp;
      }
    }
    return t.length() - tp;
  }
}