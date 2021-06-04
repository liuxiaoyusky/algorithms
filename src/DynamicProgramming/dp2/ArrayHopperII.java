package DynamicProgramming.dp2;

import java.util.Arrays;
/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.

Assumptions

    The given array is not null and has length of at least 1.

Examples

    {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)

    {2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
 */
public class ArrayHopperII {
    //have a memory to track the min step to current location
    public int minJump(int[] array) {
        //corner case
        if(array == null || array.length < 2) {
            return 0;
        }

        int [] memory = new int [array.length];
        Arrays.fill(memory, Integer.MAX_VALUE);
        memory[0] = 0;

        //for every location, if it is array.length, it isn't reached by previous loc, so return -1;
        //if not, update all reacheable location by current + 1
        for(int i = 0; i < array.length; i++) {
            if (memory[i] == Integer.MAX_VALUE) {
                return -1;
            }

            //update reachable location
            for(int j = 1; j <= array[i]; j++) {
                if (i + j < array.length) {
                    memory[i + j] = Math.min(memory[i + j], memory[i] + 1);
                }
            }

        }

        return memory[array.length - 1];
    }
}
