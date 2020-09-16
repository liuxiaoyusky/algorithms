package BinarySearch;
/*
Given a target integer T and an integer array A sorted in ascending order, find the index of the smallest element in A that is larger than T or return -1 if there is no such index.


Assumptions

There can be duplicate elements in the array.


Examples

A = {1, 2, 3}, T = 1, return 1

A = {1, 2, 3}, T = 3, return -1

A = {1, 2, 2, 2, 3}, T = 1, return 1


Corner Cases

What if A is null or A of zero length? We should return -1 in this case.
 */
public class SmallestElementLargerThanTarget {
    //ascending sorted array, return index, could be duplicated, return the first of the dup
    public int smallestElementLargerThanTarget(int[] array, int target) {
        //corner case
        if (array == null || array.length == 0 || array[array.length - 1] <= target) {
            return -1;
        }

        //define searching space
        int left = 0;
        int right = array.length - 1;

        //search until two elements
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target < array[mid]) {
                right = mid;
            } else if (target == array[mid]) {
                while(mid < right && array[mid] == array[mid + 1]) {
                    mid++;
                }
                return array[right] == target ? -1 : (mid + 1);
            } else {
                left = mid + 1;
            }
        }
        return array[left] <= target ? right : left;
    }
}
