package LinkedList;

import Recursion.ListNode;

public class MiddleNodeOfLinkedList {
    //two pointers
    public ListNode middleNode(ListNode head) {
        //clarify: if even nodes, return the left one
        //corner case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head; //this iterate the List
        ListNode slow = head; //this looking for ans

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
