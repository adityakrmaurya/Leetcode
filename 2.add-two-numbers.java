/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms Medium (41.36%) Likes: 28661 Dislikes: 5529 Total Accepted: 4M Total Submissions: 9.6M
 * Testcase Example: '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and
 * return the sum as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 = 807.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: l1 = [0], l2 = [0] Output: [0]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in each linked list is in the range [1, 100]. 0 <= Node.val <= 9 It is
 * guaranteed that the list represents a number that does not have leading zeros.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode solution = new ListNode(0);
    ListNode head = solution;
    int carry = 0;
    // 23
    // 9879
    // 128
    while (l1 != null && l2 != null) {
      carry = (l1.val + l2.val + solution.val) / 10;
      if (carry > 0 || l1.next != null || l2.next != null)
        solution.next = new ListNode(carry);
      solution.val = (l1.val + l2.val + solution.val) % 10;
      solution = solution.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    // 45
    // 7659
    // 126(0)
    if (l1 == null) {
      System.out.println("In l1 == null");
      while (l2 != null) {
        carry = (l2.val + solution.val) / 10;
        solution.val = (l2.val + solution.val) % 10;
        if (carry > 0 || l2.next != null) {
          solution.next = new ListNode(carry);
          solution = solution.next;
        }
        l2 = l2.next;
      }
      // [9,9,9,9,9,9,9]
      // [9,9,9,9]
      // [8,9,9,9,1]
    } else if (l2 == null) {
      while (l1 != null) {
        carry = (l1.val + solution.val) / 10;
        solution.val = (l1.val + solution.val) % 10;
        if (carry > 0 || l1.next != null) {
          solution.next = new ListNode(carry);
          solution = solution.next;
        }
        l1 = l1.next;
      }
    }
    return head;
  }
}
// @lc code=end
