import java.util.ArrayList;
import java.util.List;

class FindDuplicates {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
      while (nums[i] - 1 != i && nums[i] != -1) {
        int temp = nums[i];
        if (temp != nums[nums[i] - 1]) {
          nums[i] = nums[nums[i] - 1];
          nums[temp - 1] = temp;
        } else {
          nums[i] = -1;
          ans.add(nums[i]);
        }
      }
    }
    return ans;
  }
}