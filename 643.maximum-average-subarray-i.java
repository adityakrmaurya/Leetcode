class FindMaxAverage {
  public double findMaxAverage(int[] nums, int k) {
    double sum = 0;
    for (int i = 0; i < k; ++i) {
      sum += nums[i];
    }
    double maxAverage = sum / k;
    for (int i = k; i < nums.length; ++i) {
      sum = sum - nums[i - k] + nums[i];
      maxAverage = maxAverage >= sum / k ? maxAverage : sum / k;
    }
    return maxAverage;
  }
}