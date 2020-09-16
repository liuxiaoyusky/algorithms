package LinkedList;

public class CheckPalindrome {
    public static class ListNode {
        public int value;
        public ListNode next;
        public ListNode (int key) {
            this.value = key;
            next = null;
        }
    }

    //find middle, reverse the second part, them compare
    public boolean isPalindrome(ListNode head) {
        //corner case
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode newHead = reverse(middle.next); //head.length >= newHead.length
        //compare two heads
        while (newHead != null) {
            if (head.value != newHead.value) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    //fast slow pointers, slow pointing to result
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //iterate two by two
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //if there is one more, it is even and safe to return slow
        return slow;
    }

    //recursion
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main (String [] args) {
        CheckPalindrome checkPalindrome = new CheckPalindrome();
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        checkPalindrome.isPalindrome(first);
    }
}
