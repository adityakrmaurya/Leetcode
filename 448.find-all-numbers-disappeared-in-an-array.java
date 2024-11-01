import java.util.ArrayList;
import java.util.List;

class FindDisappearedNumbers {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
      while (nums[i] - 1 != i && nums[i] != -1) {
        int temp = nums[i];
        if (temp != nums[nums[i] - 1]) {
          nums[i] = nums[nums[i] - 1];
          nums[temp - 1] = temp;
        } else {
          nums[i] = -1;
        }
      }
    }
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == -1) {
        ans.add(i + 1);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    FindDisappearedNumbers solution = new FindDisappearedNumbers();
    int[] input = {4, 3, 2, 7, 8, 2, 3, 1};
    List<Integer> result = solution.findDisappearedNumbers(input);
    System.out.println("Disappeared numbers: " + result);
  }
}
