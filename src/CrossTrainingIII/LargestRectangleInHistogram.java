package CrossTrainingIII;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
Hard

Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.

Assumptions

    The given array is not null or empty

Examples

    { 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)
 */
public class LargestRectangleInHistogram {
    //a much much better solution
    public int largest2(int [] array) {
        //assumptions: array is not null, array.length >= 1
        //all the values in the array are non-negative
        int result = 0;
        //note that the stack contains the "index", not the "value" of the array.
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= array.length; i++) {
            //we need a way of popping out all the elements in the stack
            //at last, so that we explicitly add a bar of height 0.
            int cur = i == array.length ? 0 : array[i];
            // the first part means: always keep at least one element in stack, and start with the next one
            // the second part: if left smaller than cur, add it to stack and check next
            //from left to right, if height is rising, offer cur into stack and go next;
            //but as soon as height is dropping at cur, go into while loop and calculate height of prev,
            // i is right bound + 1, find left bound
            while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
                int height = array[stack.pollFirst()];
                //determine the left boundary of the largest rectangle with height array[i];
                int left = stack.isEmpty() ? 0 : stack.peekFirst() +1;
                // determine the right boundary of the largest rectangle
                //with height of the popped element.
                result = Math.max(result, height * (i - left));
            }
            stack.offerFirst(i);
        }
        return result;
    }

    //-----------------------------------------------------------------------------
    //my solution
    //[left,right] is our bounds of rectangle
    public class Tuple {
        public int index;
        public int left;
        public int right;
        public int value;
        public Tuple (int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    //clarify: given array not null or empty
    //Time:O(n) Space:O(n)
    public int largest (int [] array) {
        //init
        int n = array.length;
        Tuple [] TArray = new Tuple[n];
        for (int i = 0; i<n; i++) {
            TArray[i] = new Tuple(i,array[i]);
        }
        TArray[0].left = 0;
        TArray[n-1].right = n-1;

        //for left bound: iterate right to left; if left >= cur, skip; if left < cur, cur.left = cur, and
        // check all previous Tuple.
        //for right bound: iterate left to right; if right >= cur, skip; if right < cur, cur.right = cur, and
        // check all previous Tuple.

        Deque<Tuple> stack = new ArrayDeque<>();
        //left to right, finish right bound
        for (int i = 0; i < n; i++) {
            //this is the last node, update all remaining tuple's right bound
            if (i == n-1) {
                while (!stack.isEmpty()) {
                    Tuple prev = stack.pollFirst();
                    prev.right = n-1;
                }
            }
            else {
                //get the right Tuple
                Tuple right = TArray[i + 1];
                Tuple cur = TArray[i];

                //fill in the right bound
                //if right side is bigger, skip
                if (right.value >= cur.value) {
                    stack.offerFirst(cur);
                } else {
                    cur.right = cur.index;
                    // find one right bound, check stack
                    while (!stack.isEmpty()) {
                        Tuple prev = stack.peekFirst();
                        //update prev.right only if the right Tuple > prev.value; poll it if so; else stop the loop
                        if (prev.value > right.value) {
                            prev.right = cur.index;
                            stack.pollFirst();
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        //right to left, finish left bound
        for (int i = n-1; i >= 0; i--) {
            //this is the last node, update all remaining tuple's right bound
            if (i == 0) {
                while (!stack.isEmpty()) {
                    Tuple prev = stack.pollFirst();
                    prev.left = 0;
                }
            }
            else {
                //get the right Tuple
                Tuple left = TArray[i - 1];
                Tuple cur = TArray[i];

                //fill in the right bound
                //if left side is bigger, skip
                if (left.value >= cur.value) {
                    stack.offerFirst(cur);
                } else {
                    cur.left = cur.index;
                    // find one left bound, check stack
                    while (!stack.isEmpty()) {
                        Tuple prev = stack.peekFirst();
                        //update prev.right only if the right Tuple > prev.value; poll it if so; else stop the loop
                        if (prev.value > left.value) {
                            prev.left = cur.index;
                            stack.pollFirst();
                        } else {
                            break;
                        }
                    }
                }
            }
        }


        //finish left and right bound, now calculate the area
        int max = 0;
        for (int i = 0; i < n; i++) {
            Tuple cur = TArray[i];
            int localArea = (cur.right - cur.left + 1) * cur.value;
            max = Math.max(max,localArea);
        }

        return max;
    }

    public static void main(String [] args) {
        int [] array = new int[] {2,5,3,4,2,1,5,6};
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int res = largestRectangleInHistogram.largest(array);
        System.out.println(res);
    }
}
