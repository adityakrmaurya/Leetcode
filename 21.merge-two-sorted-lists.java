/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms Easy (63.27%) Likes: 20975 Dislikes: 1994 Total Accepted: 3.9M Total Submissions: 6.1M
 * Testcase Example: '[1,2,4]\n[1,3,4]'
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes
 * of the first two lists.
 * 
 * Return the head of the merged linked list.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: list1 = [1,2,4], list2 = [1,3,4] Output: [1,1,2,3,4,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: list1 = [], list2 = [] Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: list1 = [], list2 = [0] Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in both lists is in the range [0, 50]. -100 <= Node.val <= 100 Both list1 and
 * list2 are sorted in non-decreasing order.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. 
 * public class ListNode 
 * { int val; ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; } 
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode listNode = new ListNode();
    ListNode tail = listNode;
    while (list1 != null && list2 != null) {
      if (list1.val > list2.val) {
        tail.next = new ListNode(list2.val);
        tail = tail.next;
        list2 = list2.next;
      } else if (list1.val <= list2.val) {
        tail.next = new ListNode(list1.val);
        list1 = list1.next;
        tail = tail.next;
      }
    }
    if (list1 != null) {
      tail.next = list1;
    } else if (list2 != null) {
      tail.next = list2;
    }
    return listNode.next;
  }
}

// @lc code=end

