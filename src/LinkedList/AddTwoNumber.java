package LinkedList;
/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each
of their nodes contain a single digit. Add the two numbers and return it as a linked list.
Example
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

 */
  class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
      this.value = value;
      next = null;
    }
  }
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode head = new ListNode(0);
        dummy.next = head;
        ListNode next = new ListNode(0);
        while (l1 != null || l2 != null) {
            cur = cur.next;
            int curSum = cur.value;
            if (l1 != null) {
                curSum += l1.value;
                l1 = l1.next;
            }

            if (l2 != null) {
                curSum += l2.value;
                l2 = l2.next;
            }

            int curValue = curSum % 10;
            int nextValue = curSum / 10;
            cur.value = curValue;
            next.value = nextValue;
            cur.next = next;
            next = new ListNode(0);
        }

        if (cur.next.value == 0) {
            cur.next = null;
        }

        return dummy.next;
    }
}
