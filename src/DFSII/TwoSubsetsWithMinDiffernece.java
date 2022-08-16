package DFSII;
/*
Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.

Return the minimum difference(absolute value).

Assumptions:

    The given integer array is not null and it has length of >= 2.

Examples:

    {1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
 */
public class TwoSubsetsWithMinDiffernece {
    //each element can be in or out if there are space, try all possibilities
    //if in, left--, curDiff + array[i]; else, right--, curDiff - array[i]
    public int minDifference(int[] array) {
        int count = array.length / 2;
        int [] min = new int [] {Integer.MAX_VALUE};
        helper(array, 0, 0, count, array.length - count, min);
        return min[0];
    }

    private void helper(int [] array, int i, int curDiff, int left, int right, int [] min) {
        //base case
        if (i == array.length) {
            min[0] = Math.min(min[0], Math.abs(curDiff));
            return;
        }

        if (left > 0) {
            helper(array, i + 1, curDiff + array[i], left - 1, right, min);
        }

        if (right > 0) {
            helper(array, i + 1, curDiff - array[i], left, right - 1, min);
        }
    }
}
