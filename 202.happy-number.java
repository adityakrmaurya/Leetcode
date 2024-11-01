import java.util.HashSet;
import java.util.Set;

// Using sets
//class IsHappy {
//  public Integer sumOfDigitsSquare(int n) {
//    Integer sum = 0;
//    while (n != 0) {
//      sum += (n % 10) * (n % 10);
//      n /= 10;
//    }
//    return sum;
//  }
//
//  public boolean isHappy(int n) {
//    Set<Integer> si = new HashSet<>();
//    Integer sumOfDigitsSquare = sumOfDigitsSquare(n);
//    while (sumOfDigitsSquare != 1 && !si.contains(sumOfDigitsSquare)) {
//      si.add(sumOfDigitsSquare);
//      sumOfDigitsSquare = sumOfDigitsSquare(sumOfDigitsSquare);
//    }
//    return sumOfDigitsSquare == 1;
//  }
//}

// Using Two Pointers
class IsHappy {
  public int sumOfDigitsSquare(int n) {
    int sum = 0;
    while (n != 0) {
      sum += (n % 10) * (n % 10);
      n /= 10;
    }
    return sum;
  }

  public boolean isHappy(int n) {
    int slow = n;
    int fast = n;
    do {
      slow = sumOfDigitsSquare(slow);
      fast = sumOfDigitsSquare(sumOfDigitsSquare(fast));
    } while (slow != fast);
    return slow == 1;
  }
}