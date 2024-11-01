
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class ReorderList {
  public ListNode reverseLinkedList(ListNode start) {
    ListNode prev = null;
    ListNode next;
    while (start != null) {
      next = start.next;
      start.next = prev;
      prev = start;
      start = next;
    }
    return prev;
  }

  public ListNode middleLinkedList(ListNode start) {
    ListNode slow = start;
    ListNode fast = start;
    // fast.next is null in case of odd length linked list
    // fast.next.next is null in case of even length linked list
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    // Odd case
    if (fast.next == null) {
      return slow;
    }
    // even case
    return slow.next;
  }

  public void reorderList(ListNode head) {
    ListNode tempHead = head;
    ListNode middle = middleLinkedList(head);
    ListNode end = reverseLinkedList(middle);
    // Creating New List
    while (end != middle && head != middle) {
      ListNode startNext = head.next;
      ListNode endNext = end.next;
      head.next = end;
      end.next = startNext;
      head = startNext;
      end = endNext;
    }
    head = tempHead;
  }
}
