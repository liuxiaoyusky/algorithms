package CrossTrainingIV.prep;

/*
Merge two sorted lists into one large sorted list.

Examples

    L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
    L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
    L1 = null, L2 = null, merge L1 and L2 to null
 */
public class MergeTwoSortedLinkedList {
    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(one != null || two != null) {
            if (one == null) {
                cur.next = two;
                break;
            } else if (two == null) {
                cur.next = one;
                break;
            }
            //both not null
            else {
                if (one.value <= two.value) {
                    cur.next = one;
                    one = one.next;
                    cur = cur.next;
                } else {
                    cur.next = two;
                    two = two.next;
                    cur = cur.next;
                }
            }
        }
        return dummy.next;
    }
}
