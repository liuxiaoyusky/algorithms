package 刷题.链表;

import java.util.List;

/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)



Example 1:

Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:

Input: head = []
Output: []

Example 3:

Input: head = [1]
Output: [1]



Constraints:

    The number of nodes in the list is in the range [0, 100].
    0 <= Node.val <= 100


 */
public class SwapNodesInPairs24 {
    public ListNode swapPairs(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next.next;
        ListNode swap = head.next;
        swap.next = head;
        head.next = swapPairs(next);

        return swap;
    }


    public ListNode swapPairsI(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode next = head.next.next;
        ListNode cur = head;
        ListNode swap = head.next;
        dummy.next = swap;
        while (next != null && next.next != null) {
            swap.next = cur;
            cur.next = next.next;

            cur = next;
            swap = next.next;
            next = swap.next;
        }
        swap.next = cur;
        cur.next = next;
        return dummy.next;
    }
}
