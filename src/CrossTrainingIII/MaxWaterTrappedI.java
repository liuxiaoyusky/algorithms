package CrossTrainingIII;

    /*
    Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width
     of 1. Find the largest amount of water that can be trapped in the histogram.

Assumptions

    The given array is not null

Examples

    { 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and
    index 3, 1 unit of water can be trapped)
     */


public class MaxWaterTrappedI {
    //Time:O(n) Space:O(n)
    public int maxTrapped(int[] array) {
        // corner case
        if(array.length < 2) {
            return 0;
        }

        //init
        int n = array.length;
        int [] leftMax = new int [n];
        int [] rightMax = new int [n];
        leftMax[0] = array[0];
        rightMax[n-1] = array[n-1];

        //go through array to fill in leftMax
        //update leftMax if array[i]>leftMax[i-1]
        for (int i = 1; i < n; i++) {
            if(array[i] > leftMax[i-1]) {
                leftMax[i] = array[i];
            }else {
                leftMax[i] = leftMax[i-1];
            }
        }

        //go through array to fill in rightMax
        //update leftMax if array[i]>rightMax[i+1]
        for (int i = n-2; i >= 0; i--) {
            if(array[i] > rightMax[i+1]) {
                rightMax[i] = array[i];
            }else {
                rightMax[i] = rightMax[i+1];
            }
        }

        //go through array to get result
        int count = 0;
        for (int i = 0; i < n; i++) {
            int max = Math.min(leftMax[i],rightMax[i]);
            count += (max - array[i]);
        }
        return count;
    }
    //---------------------------------------------------------------------------------------------------
    //update version: get result when check rightMax
    //Time:O(n) Space:O(n)
    public int maxTrappedUpdated(int[] array) {
        // corner case
        if(array.length < 2) {
            return 0;
        }

        //init
        int n = array.length;
        int [] leftMax = new int [n];
        leftMax[0] = array[0];

        //go through array to fill in leftMax
        //update leftMax if array[i]>leftMax[i-1]
        for (int i = 1; i < n; i++) {
            if(array[i] > leftMax[i-1]) {
                leftMax[i] = array[i];
            }else {
                leftMax[i] = leftMax[i-1];
            }
        }

        //go through array to update right max, and at each index check how many water to count.
        int rightMax = array[n-1];
        int count = 0;
        for (int i = n-2; i >= 0; i--) {
            //check to update rightMax
            if(array[i] > rightMax) {
                rightMax = array[i];
            }
            int max = Math.min(leftMax[i],rightMax);
            count += (max - array[i]);
        }

        return count;
    }
}
