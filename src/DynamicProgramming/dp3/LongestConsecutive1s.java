package DynamicProgramming.dp3;
/*
Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

Assumptions

    The given array is not null

Examples

    {0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.
 */
public class LongestConsecutive1s {
    //prefix sum
    //base case, only one loc, return it
    //rule: for every loc, if it is one, curMax = [loc - 1] + 1, try update global max; if it is 0, curMax = 0;
    public int longest(int[] array) {
        //corner case
        if(array == null || array.length == 0) {
            return 0;
        }

        int curMax = 0;
        int globalMax = 0;

        //go through the array by the rule
        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                curMax = 0;
            }

            else {
                curMax++;
                globalMax = Math.max(globalMax, curMax);
            }
        }

        return globalMax;
    }
}
