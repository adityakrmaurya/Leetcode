import org.w3c.dom.Node;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class DetectCycle {
  public ListNode meetingPoint(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null || fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return slow;
      }
    }
    return null;
  }
  private static ListNode entryPoint(ListNode meetingPoint, ListNode head) {
    while (head != meetingPoint) {
      head = head.next;
      meetingPoint = meetingPoint.next;
    }
    return head;
  }

  public ListNode detectCycle(ListNode head) {
    ListNode meetingPoint = meetingPoint(head);
    if (meetingPoint != null) {
      return entryPoint(meetingPoint, head);
    }
    return null;
  }
}