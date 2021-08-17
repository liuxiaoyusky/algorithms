package GoogleOA;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.PriorityQueue;

/*
given an Array A, find the minimum amplitude you can get after changing up to 3 elements. Amplitude is the range of the array.
eg: input[-1,3,-1,8,5,4] Output: 2 Explanation: change -1, -1, 8. Amplitude = 5 - 3 = 2
 */
public class MinAmplitude {
    //use a minheap and max heap to mantain the smallest 4 element and largest 4 element.
    //then we compare the difference to see which pair has smallest amplitude and return

    //input int[] array, output:int
    //Time:O(2nlog4 = n) Space:O(1)
    public static int minAmplitude(int [] array) {
        //corner case
        if (array == null || array.length <= 4) {
            return 0;
        }

        //in implementation, peek returns the largest of four smallest elements
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());

        //in implementation, peek returns the smallest of four largest elements
        PriorityQueue<Integer> max = new PriorityQueue<>();

        for (int i = 0; i < array.length; i++) {
            if (i < 4) {
                min.add(array[i]);
                max.add(array[i]);
            } else {
                int fourthSmallest = min.peek();
                int fourthLargest = max.peek();
                if (array[i] < fourthSmallest) {
                    min.poll();
                    min.add(array[i]);
                }
                if (array[i] > fourthLargest) {
                    max.poll();
                    max.add(array[i]);
                }
            }
        }

        //convert pq to array. Cannot convert directly because the current order of pq is not sorted in its memory
        int [] mins = new int[4];
        for (int i = 3; i >= 0; i--) {
            mins[i] = min.poll();
        }

        int [] maxs = new int[4];
        for (int i = 3; i >= 0; i--) {
            maxs[i] = max.poll();
        }

        int chances = 3;
        int largest = 0;
        int smallest = 0;
        int minAmplitudeValue = maxs[largest] - mins[smallest];

        //go change it one by one, tracking the current min.
        while(chances > 0) {
            if (minAmplitudeValue == 0) {
                return 0;
            }

            //change one value from either mins or maxs
            int DiffereceOflarge = maxs[largest] - maxs[largest + 1];
            int DifferenceOfSmall = mins[smallest + 1] - mins[smallest];

            if (DiffereceOflarge > DifferenceOfSmall) {
                largest++;
            }else {
                smallest++;
            }

            //update chances and value
            minAmplitudeValue = maxs[largest] - mins[smallest];
            chances--;
        }

        return minAmplitudeValue;
    }
}

