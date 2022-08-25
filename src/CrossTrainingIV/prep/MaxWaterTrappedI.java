package CrossTrainingIV.prep;
/*
Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.

Assumptions

    The given array is not null

Examples

    { 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)
 */
public class MaxWaterTrappedI {
    //for index i, it can trap water if j < i
    //and arr[j] > arr[i], and i < k and arr[k] > arr[i]
    //it can trap [min(arr[j],arr[k]) - arr[i]] water

    //from left to right, if arr[i] < arr[i + 1], update max left bound
    //else, continue

    //do it again from right to left to update max right, and calculate the water
    public int maxTrapped(int[] array) {
        int [] LB = new int [array.length];
        int lMax = 0;
        for (int i = 0; i < array.length; i++) {
            lMax = Math.max(lMax, array[i]);
            LB[i] = lMax;
        }

        int water = 0;
        int rMax = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            rMax = Math.max(rMax, array[i]);
            water += Math.min(LB[i], rMax) - array[i];
        }
        return water;
    }
}
