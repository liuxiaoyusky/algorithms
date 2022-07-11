package 刷题.链表;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1]



Constraints:

    The number of nodes in the list is sz.
    1 <= sz <= 30
    0 <= Node.val <= 100
    1 <= n <= sz

 */
public class RemoveNthFromEndofList19 {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }



    //regard this as a tree with 1 branch
    //for each level, go down first to discover the current height
    //if current height is the height to move, return my lower node to upper node
    //if not, let cur.next = whatever returned
    public ListNode removeNthFromEndI(ListNode head, int n) {
        int [] height = new int[1];
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        return helper(dummy,n,height).next;
    }

    private ListNode helper (ListNode head, int n, int [] height) {
        //base case
        if (head == null) {
            height[0] = 0;
            return head;
        }

        //subproblem
        ListNode next = helper(head.next, n, height);
        height[0]++;

        //base case 2
        if (height[0] == n) {
            return next;
        }

        //general case
        head.next = next;
        return head;
    }
}
