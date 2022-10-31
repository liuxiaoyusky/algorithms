package CrossTrainingIV.prep;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumValuesOfSizeKSlidingWindows {
    //start left to right
    //keep track of the numbers when adding back and delete front
    //to mentaining
    public List<Integer> maxWindows(int[] array, int k) {
        //assume:array is not null or empty
        //assume: k >= 0 && k < array.length
        List<Integer> max = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();//save indexes in values descending order
        for (int i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }

            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            deque.offerLast(i);
            if (i >= k - 1) {
                max.add(array[deque.peekFirst()]);
            }
        }
        return max;
    }
}
