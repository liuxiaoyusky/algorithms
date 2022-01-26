package LinkedList;
/*
Given a linked list, check whether it is a palindrome.
Examples:
Input:   1 -> 2 -> 3 -> 2 -> 1 -> null
output: true.
Input:   1 -> 2 -> 3 -> null
output: false.
Requirements:
Space complexity must be O(1)
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
public class CheckIfLinkedListIsPalindrome {
    //find middle, reverse the second part, them compare
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);//first could be longer
        ListNode secondHalf = reverse(middle);


        //if not equal length, still return true since we don't care the middle node
        while (head != null && secondHalf != null) {
            if (head.value != secondHalf.value) {
                return false;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next != null) {
            slow = slow.next;
        }

        //split
        ListNode middle = slow.next;
        slow.next = null;
        return middle;
    }

    private ListNode reverse(ListNode head) {
        //corner case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode next = head.next;
        while (next != null) {
            head.next = prev;
            prev = head;
            head = next;
            next = next.next;
        }
        head.next = prev;
        return head;
    }
}
