package BinarySearch;

import java.util.Arrays;

/*
Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A. If there is a tie, the smaller elements are always preferred.

Assumptions

    A is not null
    K is guranteed to be >= 0 and K is guranteed to be <= A.length

Return

    A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.

Examples

    A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
    A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 */
//given non-negative k, ascending sorted array, k < array.length, no dup
//can return in any order, return the elements of array
//if corner case, return new int [k]
public class KClosestInSortedArray {
    //solution 2: sliding window
    //sliding window
    //time: n space:1
    public int[] kClosest2(int[] array, int target, int k) {
        //corner case
        if (array == null || array.length == 0 || k == 0) {
            return new int [k];
        }

        //define the window [left,right)
        int left = 0;
        int right = k;

        //compare array[left] and array[right + 1], if right is closer, move right; otherwise, stop
        while(right < array.length) {
            if (Math.abs(array[left] - target) > Math.abs(array[right] - target)) {
                left++;
                right++;
            } else {
                break;
            }
        }

        return Arrays.copyOfRange(array,left,right);
    }

    //-------------------------------------------------------------------------
    //solution 1: find closest first, discover rest on sides
    //time: logn + k; space: 1
    public int[] kClosest(int[] array, int target, int k) {
        //corner case
        if (array == null || array.length == 0 || k == 0) {
            return new int [k];
        }

        int [] ans = new int [k];

        //find the closest target
        int index = findClosest(array, target);
        ans[0] = array[index];

        //find the rest k elements on either side
        int left = index - 1;
        int right = index + 1;
        for (int i = 1; i < k; i++) {
            if (left >= 0 && right <= array.length - 1) {
                int l = Math.abs(target - array[left]);
                int r = Math.abs(target - array[right]);
                if (l <= r) {
                    ans[i] = array[left];
                    left--;
                } else {
                    ans[i] = array[right];
                    right++;
                }
            } else if (left >= 0) {
                ans [i] = array[left];
                left--;
            } else {
                ans[i] = array[right];
                right++;
            }
        }

        return ans;
    }

    //return index as soon as we match
    private int findClosest(int [] array, int target) {
        //define the searching space
        int left = 0;
        int right = array.length - 1;

        //check until two elements left
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return Math.abs(array[left] - target) <= Math.abs(array[right] - target) ?
                left : right;
    }
}
