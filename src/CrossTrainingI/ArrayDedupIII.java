package CrossTrainingI;

import java.util.Arrays;
/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep any of them. Do this in-place,
using the left side of the original array and and maintain the relative order of the elements of the array. Return the array after deduplication.
Assumptions
The given array is not null
Examples
{1, 2, 2, 3, 3, 3} → {1}
 */
public class ArrayDedupIII {
    public int[] dedup(int[] array) {
        //can also be done using a flag
        // clarify: sorted
        int fast = 0;
        int slow = 0;
        int start = 0;
        while(fast<array.length){
            start = fast;
            while(fast+1<array.length && array[fast+1]==array[start]){
                fast++;
            }
            fast++;
            if(start+1==fast){
                array[slow] = array[start];
                slow++;
            }
        }
        return Arrays.copyOf(array,slow);
    }
}