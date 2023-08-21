package LinkedList;

class ListNode {
    Integer value;
    ListNode next;
    ListNode(Integer v) {
        this.value = v;
        next = null;
    }

}

public class MyStack {

    private ListNode head;
    int size;

    public Stack() {
        this.head = null;
        size = 0;
    }

    public Integer pop() {
        if (head == null) {
            return null;
        }

        ListNode popNode = head;
        head = head.next;
        size--;
        return popNode.value;
    }

    public Integer peek(){
        if (head == null) {
            return null;
        }

        return head.value;
    }

    public void push(Integer num) {
        ListNode newHead = new ListNode(num);
        size++;
        newHead.next = head;
        head = newHead;
    }


    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }


}