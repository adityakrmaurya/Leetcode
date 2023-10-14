/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

class Solution {
  public int[] twoSum(final int[] nums, final int target) {
    final int[] ans = {-1, -1};
    for (int i = 0; i < nums.length; ++i) {
      ans[0] = i;
      for (int j = i + 1; j < nums.length; ++j) {
        if (nums[i] + nums[j] == target) {
          ans[1] = j;
          return ans;
        }
      }
    }
    return ans;
  }
}
// @lc code=end
