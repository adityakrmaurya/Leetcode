package twoPointers;

class TwoSum2 {
  public int[] twoSum(int[] numbers, int target) {
    int[] pair = new int[2];
    int start = 0;
    int end = numbers.length - 1;
    while (start < end) {
      if (numbers[start] + numbers[end] == target) {
        pair[0] = start + 1;
        pair[1] = end + 1;
      } else if (numbers[start] + numbers[end] < target) {
        start++;
      } else {
        end--;
      }
    }
    return pair;
  }
}
