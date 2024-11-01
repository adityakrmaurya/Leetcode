class NumberToWords {
  public String printWord(int word, int place) {
    System.out.println(word);
    return new String();
  }
  public String numberToWords(int num) {
    int place = 0;
    while (num != 0) {
      printWord(num % 1000);
      num /= 1000;
    }
    return new String();
  }
  public static void main(String[] args){
    NumberToWords nw = new NumberToWords();
    nw.numberToWords(123000);
  }
}