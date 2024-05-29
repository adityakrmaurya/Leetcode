package twoPointers;

/**
 * 11. Container With Most Water
 *
 * <p>You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * <p>Find two lines that together with the x-axis form a container, such that the container
 * contains the most water.
 *
 * <p>Return the maximum amount of water a container can store.
 *
 * <p>Notice that you may not slant the container.
 *
 * <p>Example 1:
 *
 * <p>Input: height = [1,8,6,2,5,4,8,3,7] Output: 49 Explanation: The above vertical lines are
 * represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 *
 * <p>Example 2:
 *
 * <p>Input: height = [1,1] Output: 1
 *
 * <p>Constraints:
 *
 * <p>n == height.length 2 <= n <= 105 0 <= height[i] <= 104
 */
class MaxArea {
  public int maxArea(int[] height) {
    int start = 0;
    int end = height.length - 1;
    int areaMax = -1;
    while (start < end) {
      int currentArea = Math.min(height[start], height[end]) * (end - start);
      if (areaMax < currentArea) {
        areaMax = currentArea;
      }
      if (height[start] < height[end]) {
        start++;
      } else {
        end--;
      }
    }
    return areaMax;
  }
}
