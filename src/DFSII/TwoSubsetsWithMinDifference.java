package DFSII;

/*
Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.

Return the minimum difference(absolute value).

Assumptions:

    The given integer array is not null and it has length of >= 2.

Examples:

    {1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
 */


public class TwoSubsetsWithMinDifference {
    //cut array into two, with one subset at n/2 size
    public int minDifference(int[] array) {
        //worst case, find pairs of all possible combination and find min
        //each element go either left or right
        //Time:O(2^n) Space:(n^2)

        //corner case
        if (array == null || array.length < 2) {
            return -1;
        }

        //do it by recursion;
        //value in left marked as positive value
        //in right marked as negtive
        //save an array to save global value 0:globalMin
        int index = 0;
        int curDiff = 0;
        int count = array.length/2;
        int [] info = new int []{Integer.MAX_VALUE};
        minHelper(array,index, curDiff, count, array.length - count, info);

        return info[0];
    }

    //index means current value to check;
    //update globalMin at index = length - 1;
    private void minHelper(int [] array, int index, int curDiff, int left, int right, int [] info) {
        //base case
        if (index == array.length) {
            info[0] = Integer.min(info[0], Math.abs(curDiff));
            return;
        }

        //current level: check array[index] on left or right
        if(left > 0) {
            minHelper(array,index + 1, curDiff + array[index],left - 1, right, info);
        }
        if (right > 0) {
            minHelper(array,index + 1,curDiff - array[index], left, right - 1, info);
        }



        //return to upper level
        return;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    //followup: what if you can constitude the subset by picking up any number of elements from the array?
    public int minDifferenceII(int[] array) {
        //worst case, find pairs of all possible combination and find min
        //each element go either left or right
        //Time:O(2^n) Space:(n^2)

        //corner case
        if (array == null || array.length < 2) {
            return -1;
        }

        //do it by recursion;
        //value in left marked as positive value
        //in right marked as negtive
        //save an array to save global value 0:globalMin
        int index = 0;
        int curDiff = 0;
        int [] info = new int []{Integer.MAX_VALUE};
        minHelper(array,index, curDiff,info);

        return info[0];
    }

    //index means current value to check;
    //update globalMin at index = length - 1;
    private void minHelper(int [] array, int index, int curDiff, int [] info) {
        //base case
        if (index == array.length) {
            info[0] = Integer.min(info[0], Math.abs(curDiff));
            return;
        }

        //current level: check array[index] on left or right
        minHelper(array,index + 1, curDiff + array[index], info);
        minHelper(array,index + 1,curDiff - array[index], info);


        //return to upper level
        return;
    }
}
