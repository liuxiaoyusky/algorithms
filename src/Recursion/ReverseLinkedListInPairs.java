package Recursion;

import java.util.ArrayList;

public class ReverseLinkedListInPairs {

    public LinkedNode reverseInPairs(LinkedNode head) {
        //(0)12?
        LinkedNode prev=new LinkedNode(0);
        prev.next = head;
        LinkedNode cur = prev;
        ArrayList<Integer> ans = new ArrayList<>();

        //not work when 3 is null
        //while(cur.next!=null||cur.next.next!=null){
        //  Recursion.ListNode nextPairHead=cur.next.next.next;//3
        //  cur.next.next.next=cur.next;// (02)->1 3
        //  cur.next=cur.next.next;//0->2->1 3
        //  cur.next.next.next=nextPairHead;//0->2->1->3
        //  cur=cur.next.next;
        //}

        while(cur.next!=null&&cur.next.next!=null){
            LinkedNode nextNode=cur.next.next;//2
            cur.next.next=nextNode.next;//0(12)->3
            nextNode.next=cur.next;//(02)->1>3
            cur.next=nextNode;
            cur=cur.next.next;
        }

        return prev.next;
    }

    //----------------------------------------
    //solution2 by recursion
    public ListNode reverseInPairsRecursion(ListNode head){
        if(head==null||head.next==null){
            return head;
        }

        ListNode newHead=head.next;
        head.next=reverseInPairsRecursion(head.next.next);
        newHead.next=head;

        return newHead;
    }
}
