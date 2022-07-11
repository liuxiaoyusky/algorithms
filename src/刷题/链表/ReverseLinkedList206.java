package 刷题.链表;

import java.util.List;

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:

    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000



Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

 */
public class ReverseLinkedList206 {
    //input: listNode
    //Output: listNode
    public ListNode reverseList(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }

        //general case
        //smaller problem
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }


    public ListNode reverseListII(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = cur.next;
            next = next.next;
        }
        next.next = cur;
        return next;
    }
}
