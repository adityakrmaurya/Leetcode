/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms Hard (60.01%) Likes: 29401 Dislikes: 423 Total Accepted: 1.7M Total Submissions: 2.9M
 * Testcase Example: '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6 Explanation: The above elevation map (black
 * section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
 * (blue section) are being trapped.
 *
 *
 * Example 2:
 *
 *
 * Input: height = [4,2,0,3,2,5] Output: 9
 *
 *
 *
 * Constraints:
 *
 *
 * n == height.length 1 <= n <= 2 * 10^4 0 <= height[i] <= 10^5
 *
 *
 */

// @lc code=start
class Trap {
  public int trap(int[] height) {
    int totalWater = 0;
    int[] leftMax = new int[height.length];
    int[] rightMax = new int[height.length];
    // Traverse from left to right, find greatest max to left.
    for (int i = 0; i < height.length; ++i) {
      if (i == 0) {
        leftMax[i] = 0;
        rightMax[height.length - i - 1] = 0;
      } else {
        leftMax[i] = Integer.max(leftMax[i - 1], height[i - 1]);
        rightMax[height.length - i - 1] =
            Integer.max(rightMax[height.length - i], height[height.length - i]);
      }
    }
    for (int i = 0; i < height.length; ++i) {
      totalWater +=
          (Integer.min(leftMax[i], rightMax[i]) - height[i] <= 0)
              ? 0
              : Integer.min(leftMax[i], rightMax[i]) - height[i];
    }
    return totalWater;
  }
}
// @lc code=end
