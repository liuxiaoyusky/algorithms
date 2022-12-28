package HybridDataStructureDesign;

import java.util.*;

//assume no dup
/*
clarify:
MaxStack(): init
push(int element): push the element to the top
pop(): return the top element and remove it, return -1 if empty
peek(): return the top element, return -1 if empty
peekmax(): return the current max value in the stack
popmax(): return the current max and remove it

other clarify: if stack is empty, if multiple max, pop the most recent one
 */
public class StackWithMaxRemoval2 {
    //solution 1: stack(for push, pop, peek) + pq(for max)
    /*
    push: O(1) + O(logn)
    pop():O(1) + O(n)(need use remove() for pq)
    peek(): O(1) stack
    popMax(): O(n) remove last occurence(value) + O(logn) pq

    Deque<Integer> stack;
    PriorityQueue<Integer> max;
    public StackWithMaxRemoval2() {
        stack = new LinkedList<>();
        max = new PriorityQueue<>((a,b) -> (b - a));
    }

    public void push(int x) {
        stack.offerLast(x);
        max.offer(x);
    }

    public int pop(){
        int toBeDeleted = stack.pollLast();
        max.remove(toBeDeleted);
        return toBeDeleted;
    }

    public int top(){
        return stack.peekLast();
    }

    public int peekMax(){
        return max.peek();
    }

    public int popMax(){
        int toBeDeleted = max.poll();
        stack.removeLastOccurrence(toBeDeleted);
        return toBeDeleted;
    }

 */

//solution 2: 解决不足：两个remove 时间太高：double linkedlist + treeMap<value, come in order>

    static class Node{
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private TreeMap<Integer, List<Node>> treeMap;

    public StackWithMaxRemoval2() {
        this.treeMap = new TreeMap<>();
    }

    public void push(int x) {
        Node cur = new Node(x);
        append(cur);
        List<Node> list = treeMap.get(x);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(cur);
        treeMap.put(x, list);
    }

    public int pop() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        Node node = head;
        remove(node);
        updateMap(node);
        return node.val;
    }

    public int top() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        return head.val;
    }

    public int peekMax(){
        if (treeMap.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return treeMap.lastKey();
    }

    public int popMax() {
        if (treeMap.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int maxKey = treeMap.lastKey();
        List<Node> maxList = treeMap.get(maxKey);
        Node maxNode = maxList.get(maxList.size() - 1);
        remove(maxNode);
        updateMap(maxNode);
        return maxNode.val;
    }

    private void updateMap(Node node) {
        List<Node> list = treeMap.get(node.val);
        if (list.size() == 1) {
            treeMap.remove(node.val);
        } else {
            list.remove(list.size() - 1);
        }
    }

    private void remove(Node node) {
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node == head) {
            head = head.next;
        }

        if (node == tail) {
            tail = tail.prev;
        }
    }

    private void append(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }


}
