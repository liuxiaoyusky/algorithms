package LinkedList;

import Recursion.ListNode;

public class ReverseLinkedListIterative {
    public ListNode reverse(ListNode head) {
        //think about a sliding window with only two space, the first is prev, the second is head
        //it will start with prev = null, and stop when head == null
        ListNode prev = null;
        //corner case is included in while loop
        while (head != null) {
            //save the next
            ListNode next = head.next;
            //link prev
            head.next = prev;
            //move forward
            prev = head; //this is the new head when head == null
            head = next;
        }
        return prev;
    }
}
