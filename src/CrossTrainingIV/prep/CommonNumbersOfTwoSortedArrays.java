package CrossTrainingIV.prep;

import java.util.LinkedList;
import java.util.List;

/*
Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
Assumptions
    In each of the two sorted arrays, there could be duplicate numbers.
    Both two arrays are not null.

Examples
    A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
 */
public class CommonNumbersOfTwoSortedArrays {
    //input two int array, output List<Integer>
    //sorted in ascending order, with dup
    //both array not null
    //if one array is extramely shorter than the other,
    //assume A is the shorter one, binary search A in B;
    //if two arrays are about the same length, two pointer.
    //if not sorted, try map.
    public List<Integer> common(int[] A, int[] B) {
        List<Integer> ans = new LinkedList<>();
        if (A.length == 0 || B.length == 0) {
            return ans;
        }

        int leftBound = 0;
        //assume A is shorter, bs A in B
        for (int a : A) {
            leftBound = helper(a, leftBound, B, ans);
        }

        return ans;
    }

    //if found at i, return i + 1, add B[i] to ans
    //if not found, return rightmost j that is B[j] < target
    private int helper(int target, int leftBound, int [] B, List<Integer> ans) {

        int left = leftBound;
        int right = B.length - 1;

        if (leftBound > right) {
            return leftBound;
        }

        //base case
        if (target < B[leftBound]) {
            return leftBound;
        }

        //until only one element in searching space
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (B[mid] == target) {
                while (mid > left && B[mid] == B[mid - 1]) {
                    mid--;
                }
                ans.add(target);
                return mid + 1;
            } else if (B[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (B[left] == target) {
            ans.add(target);
            return left + 1;
        } else if (B[left] < target) {
            return left + 1;
        } else {
            return left;
        }
    }
}
