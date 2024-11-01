
class HasCycle {
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != slow && fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if (fast == slow) {
      return true;
    }
    return false;
  }
}
