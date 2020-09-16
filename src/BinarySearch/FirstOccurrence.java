package BinarySearch;
/*
Given a target integer T and an integer array A sorted in ascending order, find the index of the first occurrence of T in A or return -1 if there is no such index.

Assumptions

    There can be duplicate elements in the array.

Examples

    A = {1, 2, 3}, T = 2, return 1
    A = {1, 2, 3}, T = 4, return -1
    A = {1, 2, 2, 2, 3}, T = 2, return 1

Corner Cases

    What if A is null or A of zero length? We should return -1 in this case.
 */
public class FirstOccurrence {
    //ascending sorted array, can be dup, return leftmost if exist
    public int firstOccur(int[] array, int target) {
        //corner case
        if (array == null || array.length == 0) {
            return -1;
        }

        //define seraching space
        int left = 0;
        int right = array.length - 1;

        //search until no element in searching space
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                while (mid > left && array[mid] == array[mid - 1]) {
                    mid--;
                }
                return array[left] == target ? left : mid;
            } else if (array[mid] < target) {
                //target in right half
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

