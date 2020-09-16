package CrossTrainingIII.WarmUp;
import Recursion.ListNode;

public class MergeTwoSortedLinkedLists {
    //time: O(n) space:O(1) //n is the total length of two listNode
    public ListNode merge(ListNode one, ListNode two) {
        //corner case
        if (one == null) {
            return two;
        } else if (two == null) {
            return one;
        }

        ListNode dummy = new ListNode(0);//dummy head
        ListNode cur = dummy;// track current node, link next node to cur

        //find next node
        while (one!=null && two!=null) {
            if (one.key <= two.key) {
                cur.next = one;
                cur = cur.next;
                one = one.next;
            } else {
                cur.next = two;
                cur = cur.next;
                two = two.next;
            }
        }

        //link the rest nodes
        if (one!=null) {
            cur.next = one;
        } else {
            cur.next = two;
        }

        //return what behind dummy
        return dummy.next;
    }
}

