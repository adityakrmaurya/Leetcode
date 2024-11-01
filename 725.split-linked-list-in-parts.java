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
class SplitListToParts {
  public int lengthOfLinkedList (ListNode head) {
    int length = 0;
    while (head != null) {
      ++length;
      head = head.next;
    }
    return length;
  }
  public ListNode[] splitListToParts(ListNode head, int k) {
    int sizeLinkedList = lengthOfLinkedList(head);
    int elementsInBucket = sizeLinkedList / k;
    int remainder = sizeLinkedList - (elementsInBucket * k);
    ListNode[] ans = new ListNode[k];
    for (int i = 0; i < k; ++i) {
      ans[i] = head;
      int nodesInBuket = elementsInBucket + (remainder > 0 ? 1 : 0);
      --remainder;
      while (--nodesInBuket > 0) {
        head = head.next;
      }
      ListNode headNext = head != null ? head.next : null;
      if (head != null) {
        head.next = null;
      }
      head = headNext;
    }
    return ans;
  }
}