package CrossTrainingI;

import java.util.Arrays;
/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep only one of them.
Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.
Assumptions
The array is not null
Examples
{1, 2, 2, 3, 3, 3} → {1, 2, 3}
 */

//time O(n) space O(1)
public class ArrayDedupI {
    public int[] dedup(int[] array) {
        // clarify: not null, sorted, in-place
        int slow = 0;//[o,slow-1] is what we want
        int fast = 0;//[fast,] is what we will check
        while(fast<array.length){
            int cur = array[fast];
            if(fast+1<array.length && array[fast+1]==array[fast]){
                fast++;
            }else{
                array[slow] = cur;
                slow++;
                fast++;
            }
        }
        //usually just need to return the length of valid array, here is used for laicode check
        return Arrays.copyOf(array,slow);
    }
}
