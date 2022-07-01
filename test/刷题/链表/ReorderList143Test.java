package 刷题.链表;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReorderList143Test {

    ReorderList143 r;
    ListNode one;
    ListNode seven;
    @BeforeEach
     void init(){
        one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        seven = new ListNode(7);
        one.next = two;
        two.next = three;
        three.next = four;

        seven.next = six;
        six.next = five;

        r = new ReorderList143();

    }

    @Test
    void findmid() {
        ListNode newhead = r.findMid(one);
        assertEquals(3, newhead.val);
        assertEquals(4, newhead.next.val);
        assertEquals(1, one.val);
        assertEquals(2, one.next.val);

    }

    @Test
    void reverse(){
        ListNode newhead = r.reverse(one);
        assertEquals(4, newhead.val);
        assertEquals(3, newhead.next.val);
        assertEquals(2, newhead.next.next.val);
        assertEquals(1, newhead.next.next.next.val);
    }

    @Test
    void merge() {
        r.merge(seven, one);
        assertEquals(7, seven.val);
        assertEquals(1, seven.next.val);
        assertEquals(6, seven.next.next.val);
        assertEquals(2, seven.next.next.next.val);
        assertEquals(5, seven.next.next.next.next.val);
        assertEquals(3, seven.next.next.next.next.next.val);
        assertEquals(4, seven.next.next.next.next.next.next.val);
    }

    @Test
    void reorder() {
        r.reorderList(one);
        assertEquals(1, one.val);
        assertEquals(4, one.next.val);
        assertEquals(2, one.next.next.val);
        assertEquals(3, one.next.next.next.val);
    }


}