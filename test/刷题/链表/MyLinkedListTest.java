package 刷题.链表;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    @Test
    void test1() {
        MyLinkedList list = new MyLinkedList();
        Assertions.assertEquals(-1, list.get(0));
        list.addAtHead(1);
        Assertions.assertEquals(1, list.get(0));
        list.addAtTail(3);
        list.addAtIndex(1,2);
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(3, list.get(2));
        list.deleteAtIndex(1);
        Assertions.assertEquals(3, list.get(1));
        list.deleteAtIndex(2);
    }

}