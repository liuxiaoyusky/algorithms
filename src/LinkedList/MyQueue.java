package LinkedList;

class ListNode{
    Integer value;
    ListNode next;
    ListNode(Integer v) {
        this.value = v;
        next = null;
    }

}
public class MyQueue{

    ListNode head;
    ListNode tail;
    int size;

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public Integer offer(Integer num) {
        ListNode newNode = new ListNode(num);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size = 1;
            return;
        }

        size++;
        tail.next = newNode;
        tail = tail.next;
    }

    public Integer poll() {
        if (head == null) {
            return null;
        }

        Integer value = head.value;
        head =head.next;
        size--;
        return value;
    }

    public Integer peek(){
        if (head == null) {
            return null;
        }

        return head.value;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}