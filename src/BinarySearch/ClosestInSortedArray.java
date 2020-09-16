package BinarySearch;
/*
Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.

Assumptions

    There can be duplicate elements in the array, and we can return any of the indices with same value.

Examples

    A = {1, 2, 3}, T = 2, return 1
    A = {1, 4, 6}, T = 3, return 1
    A = {1, 4, 6}, T = 5, return 1 or 2
    A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2

Corner Cases

    What if A is null or A is of zero length? We should return -1 in this case.
 */
public class ClosestInSortedArray {
    //ascending sorted
    //return closest, with dup, can be any index of same value
    public int closest(int[] array, int target) {
        //corner case
        if (array == null || array.length == 0) {
            return -1;
        }

        //define searching space
        int left = 0;
        int right = array.length - 1;

        //search until less than two elements in searching space
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                //target on right half, but array[mid] could be the closest
                left = mid;
            } else {
                right = mid;
            }
        }

        return Math.abs(array[left] - target) < Math.abs(array[right] - target) ?
                left : right;
    }
}


