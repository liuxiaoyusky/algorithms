package DynamicProgramming.dp1;
/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). Determine if you are able to reach the last index.

Assumptions

    The given array is not null and has length of at least 1.

Examples

    {1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)

    {2, 1, 1, 0, 2}, we are not able to reach the end of array
 */
public class ArrayHopperI {
    //keep a bool array to keep track of the status of current index ==> keep an int to track the most far away index
    //if array[cur] == true, update all following A[cur](update most far away) to be ture and check array[cur+1];
    //else stop and return false
    public boolean canJump(int[] A) {
        //corner case
        if (A == null || A.length < 2) {
            return true;
        }

        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            //check if cur is reachable from previous
            if (i <= cur) {
                cur = Math.max(cur, i + A[i]);
                if (cur > A.length) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
