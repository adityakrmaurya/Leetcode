/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms Medium (33.39%) Likes: 29683 Dislikes: 2711 Total Accepted: 3.2M Total Submissions:
 * 9.5M Testcase Example: '[-1,0,1,2,-1,-4]'
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i !=
 * j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Explanation: nums[0] + nums[1] +
 * nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0. nums[0] + nums[3] +
 * nums[4] = (-1) + 2 + (-1) = 0. The distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the
 * order of the output and the order of the triplets does not matter.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [0,1,1] Output: [] Explanation: The only possible triplet does not sum up to 0.
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [0,0,0] Output: [[0,0,0]] Explanation: The only possible triplet sums up to 0.
 *
 *
 *
 * Constraints:
 *
 *
 * 3 <= nums.length <= 3000 -10^5 <= nums[i] <= 10^5
 *
 *
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    List<List<Integer>> solution = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; ++i) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      for (int j = i + 1; j < nums.length - 1; ++j) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int idx = Arrays.binarySearch(nums, j + 1, nums.length, -(nums[i] + nums[j]));
        if (idx > j) {
          List<Integer> li = new ArrayList<>();
          li.add(nums[i]);
          li.add(nums[j]);
          li.add(nums[idx]);
          solution.add(li);
        }
      }
    }
    return solution;
  }
}

// @lc code=end
// -4, -1, -1, 0, 1, 2
