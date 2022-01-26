package LinkedList;
/*
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be
 N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
Examples
    L = null, is reordered to null
    L = 1 -> null, is reordered to 1 -> null
    L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
    L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
 */
/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class ReorderLinkedList {
    //find the middle point, cut, reverse the second part, merge two parts
    public ListNode reorder(ListNode head) {
        //corner case
        if (head == null || head.next == null) {
            return head;
        }

        //middle = the n/2th(to left) node
        ListNode middle = findMiddle(head);
        ListNode right = reverse(middle.next);
        return merge(head,right);
    }

    private ListNode merge (ListNode left, ListNode right) {
        ListNode first = left;
        ListNode second = right;
        while (second != null) {
            ListNode third = first.next;
            ListNode forth = second.next;

            first.next = second;
            second.next = third;

            first = third;
            second = forth;
        }
        if (first.next != null) {
            first.next = second;
        }
        return left;
    }

    //recursion
    private ListNode reverse (ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }

        //sub-problem
        ListNode newHead = reverse(head.next);

        //curlevel
        head.next.next = head;
        head.next = null;

        return newHead;
    }



    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
