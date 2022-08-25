package CrossTrainingIV.prep;

import java.util.Deque;
import java.util.LinkedList;

/*
Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest rectangular area that can be formed in the histogram.

Assumptions

    The given array is not null or empty

Examples

    { 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)
 */
public class LargestRectangleInHistogram {
    //find the left and right bound with current index height
    //right to left, update left bound
    //if larger or equal height bound, continue;
    //if smaller, reaches the left bound, go backwards, update all previous leftbound,
    //if bound[i] < bound[cur], then bound[i + 1] is the left bound of i,
    //go right one by one, if the right value is larger, update it's left bound and continue;
    //else, break and keep searching
    //
    //same to right
    //then calculate the largest rectangles
    //Time O(n) Space O(n)

    class Tuple{
        public int left;
        public int right;
        public int value;
        public Tuple(int value) {
            this.value = value;
        }
    }

    public int largest(int[] array) {
        Tuple [] arr = new Tuple [array.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = new Tuple(array[i]);
        }


        Deque<Tuple> stack = new LinkedList<>();
        //left to right, update right bound
        for(int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                while (!stack.isEmpty()) {
                    Tuple cur = stack.pop();
                    cur.right = array.length - 1;
                }
            } else if (array[i] <= array[i + 1]) {
                stack.push(arr[i]);
            } else {
                arr[i].right = i;
                while (!stack.isEmpty()) {
                    Tuple cur = stack.peek();
                    if (cur.value > array[i + 1]) {
                        cur.right = i;
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
        }

        //right to left, update left bound
        for(int i = array.length - 1; i >= 0; i--) {
            if (i == 0) {
                while (!stack.isEmpty()) {
                    Tuple cur = stack.pop();
                    cur.left = 0;
                }
            } else if (array[i - 1] >= array[i]) {
                stack.push(arr[i]);
            } else {
                arr[i].left = i;
                while (!stack.isEmpty()) {
                    Tuple cur = stack.peek();
                    if (array[i - 1] < cur.value) {
                        cur.left = i;
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
        }

        //find largest rec
        int largest = 0;
        for (Tuple t: arr) {
            int cur = t.value * (t.right - t.left + 1);
            largest = Math.max(largest, cur);
        }

        return largest;
    }
}
