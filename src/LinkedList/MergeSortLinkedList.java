package LinkedList;
/*
Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The merge sort
algorithm should be used to solve this problem.
Examples
    null, is sorted to null
    1 -> null, is sorted to 1 -> null
    1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
    4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
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
public class MergeSortLinkedList {
    //split and merge
    public ListNode mergeSort(ListNode head) {
        //cut the list to two before middle, so middle is the new head
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //cut
        ListNode middle = slow.next;
        slow.next = null;

        //keep spliting
        head = mergeSort(head);
        middle = mergeSort(middle);

        return merge(head,middle);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }

            cur = cur.next;
            cur.next = null;
        }

        if (head1 == null) {
            cur.next = head2;
        } else {
            cur.next = head1;
        }

        return dummy.next;
    }

}
