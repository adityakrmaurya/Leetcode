import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
  public boolean isPalindrome(ListNode head) {
    // Using 2ptr : Slow & Fast
    // Slow: jumps one step
    // Fast: jumps two steps
    // store next of slow
    // then reverse
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;
    ListNode slowNext = head.next;
    // Base Case
    // One Element or Two Element
    if (slowNext == null || (slowNext != null && fast.next.next == null && slowNext.val == slow.val)) {
      return true;
    } else if (slowNext != null && fast.next.next == null && slowNext.val != slow.val) {
      return false;
    }
    // 3 or more elements
    while (fast.next.next != null) {
      slowNext = slow.next;
      slow.next = prev;
      prev = slow;
      slow = slowNext;
      fast = fast.next.next;
    }


  }
}

1 2 3 4 5