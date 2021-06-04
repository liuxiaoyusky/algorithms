package DynamicProgramming.dp1;

public class LongestAscendingSubArray {
    /*
    Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.
Assumptions
    The given array is not null
Examples
    {7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
    {1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
     */

    public static int longest(int [] array) {
        //dp: track the longest from index 0 to cur
        //base case: array == null || array is empty
        if (array == null || array.length == 0) {
            return 0;
        }

        int longest = 1;
        int cur = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                cur++;
            } else {
                longest = Math.max(longest, cur);
                cur = 1;
            }
        }
        //in case for all ascending
        longest = Math.max(longest, cur);

        return longest;
    }
}
