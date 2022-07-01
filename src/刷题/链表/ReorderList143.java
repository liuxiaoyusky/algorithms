package 刷题.链表;
/*
You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Constraints:
    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000

 */

import java.util.List;

public class ReorderList143 {

     //step 1: find the middle point, split list to two parts, right part is longer than right
    //step 2: reverse the second part
    //step 3: merge two lists
    public void reorderList(ListNode head) {
        //corner case, only one element
        if (head.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode second = reverse(mid);
        merge(head, second);
    }

    public ListNode findMid(ListNode head) {
        ListNode prev = null;
        ListNode mid = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            prev = mid;
            cur = cur.next.next;
            mid = mid.next;
        }

        prev.next = null;
        return mid;
    }

    public ListNode reverse( ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;

        return cur;
    }

    public void merge(ListNode one, ListNode two) {
        ListNode l = one;
        ListNode r = two;
        ListNode lnext = l.next;
        ListNode rnext = r.next;
        while (l.next != null) {
            l.next = r;
            r.next = lnext;
            l = lnext;
            r = rnext;
            lnext = lnext.next;
            rnext = rnext.next;
        }
        l.next = r;
        if (rnext != null) {
            rnext.next = null;
        } else {
            r.next = null;
        }
    }
}
