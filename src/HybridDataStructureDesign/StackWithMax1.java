package HybridDataStructureDesign;

import java.util.Deque;
import java.util.LinkedList;

//assume no dup
/*
push(int element): push the element to the top
pop(): return the top element and remove it, return -1 if empty
peek(): return the top element, return -1 if empty
getmax(): return the current max value in the stack
 */
public class StackWithMax1 {
    private Deque<Integer> stack;
    private Deque<Integer> maxStack;
    public StackWithMax1(){
        this.stack = new LinkedList<>();
        this.maxStack = new LinkedList<>();
    }

    public Integer getMax() {
        if (maxStack.isEmpty()){
            return null;
        }
        return maxStack.peekFirst();
    }

    public void push(int value) {
        stack.offerFirst(value);
        if (maxStack.isEmpty() || value >= maxStack.peekFirst()) {
            maxStack.offerFirst(value);
        }
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        Integer result = stack.pollFirst();

        if (maxStack.peekFirst().equals(result)) {
            maxStack.pollFirst();
        }
        return result;
    }

    public Integer peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peekFirst();
    }
}
