package LinkedList;

import Recursion.ListNode;

public class ReverseLinkedListRecursive {
    public ListNode reverse(ListNode head) {
        //base case:last valid node
        if (head == null || head.next == null) {
            return head;
        }

        //1.find the next
        ListNode newhead = reverse(head.next);

        //2.do the recursion content in current level, link next head to current
        //sliding window of two nodes

        //link the 2nd node to 1st
        //ListNode next = head.next;
        head.next.next = head;//next.next = head;

        //cut the loop
        head.next = null;



        //3.return the new head
        return newhead;
    }
}
