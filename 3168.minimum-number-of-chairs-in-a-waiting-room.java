class minimumChairs {
  public int minimumChairs(String s) {
    int maxChairs = 0;
    int currChairs = 0;
    for (var x : s.toCharArray()) {
      if (x == 'E'){
        ++currChairs;
        if (currChairs > maxChairs) {
          maxChairs = currChairs;
        }
      } else {
        --currChairs;
      }
    }
    return maxChairs;
  }
}