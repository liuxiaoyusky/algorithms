package DynamicProgramming.dp2;
/*
Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

Assumptions

    The given array is not null and has length of at least 1.

Examples

    {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
    {-2, -1, -3}, the largest subarray sum is -1
 */
public class LargestSubArraySum {
    //maintain a memory contains the max including the current loc
    //rule: if max(array[cur], array[cur] + m[cur - 1])
    //since we only care the global max and the max of previous loc, we can only safe these two values
    public int largestSum(int[] array) {
        //corner case
        if (array == null || array.length == 0) {
            return 0;
        }

        int globalMax = array[0];
        int curMax = array[0];

        for (int i = 1; i < array.length; i++) {
            curMax = Math.max(array[i], curMax + array[i]);
            globalMax = Math.max(curMax,globalMax);
        }

        return globalMax;
    }
}
