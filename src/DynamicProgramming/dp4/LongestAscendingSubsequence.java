package DynamicProgramming.dp4;
/*
Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.

Assumptions

    A is not null

Examples
Input: A = {5, 2, 6, 3, 4, 7, 5}
Output: 4
Because [2, 3, 4, 5] is the longest ascending subsequence.
 */
public class LongestAscendingSubsequence {
    //dp, iterate from left to right
    //assume no dup, array not null
    //clarify: equal value not count as ascending
    //Time: O(n ^2) Space: O(n), n is the length of array
    public int longest(int[] array) {
        //corner case
        if (array.length < 2) {
            return array.length;
        }

        //count[i] represent the longest subsequence including i
        int [] count = new int [array.length];
        int maxCount = 1;
        count[0] = 1;
        //two cases from j in 0 - i-1
        //case 1: count[i] > count[j], count[i] = max(count[i],count[j] + 1)
        //case 2: i <= j, skip;
        for (int i = 1; i < array.length; i++) {
            count[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] > array[j]) {
                    count[i] = Math.max(count[i],count[j] + 1);
                }
            }
            maxCount = Math.max(maxCount, count[i]);
        }
        return maxCount;
    }

    // solution 2: o(nlogn) 看不懂
    public int longestII (int[] array) {
        if (array.length == 0) {
            return 0;
        }

        // tbl[i]: the smallest ending value of all the ascending subsequences with length i
        int [] tbl = new int[array.length + 1];
        //at the very begining, the longest ascending subsequence we have has length 1 (array[0] itself).
        int result = 1;
        // init: at the very beginning, we have a length 1 ascending subsequence, ending value as array[0].
        // while we traversing the array, we will update existing tbl[i] and find new longer ascending subsequence
        tbl[1] = array[0];
        for (int i = 1; i < array.length; i++) {
            // tbl is guaranteed to be in ascending order - the key point.
            // from tbl, find the best（longest) ascending subsequence, which can concatenate array[i] to form a new one.
            // this is actually a binary search of the "largest smaller value".
            int index = find(tbl, 1, result, array[i]);
            //two cases:
            //1. we can possibly form a longer ascending subsequence than whatever we have before, if array[i] is larger
            //than all values in tbl.
            //2. we may update btl[index + 1] because we find a better ascending subsequence with length index + 1(the
            //ending value is smaller or equal).
            if (index == result) {
                tbl[++result] = array[i];
            } else {
                tbl[index + 1] = array[i];
            }
         }
        return result;
    }

    //find the index of the "largest smaller value" to target in the tbl, tbl is sorted in ascending order.
    private int find(int [] tbl, int left, int right, int target) {
        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            if (tbl[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        for (int j = right; j >= left; j--) {
            if (tbl[j] < target) {
                return j;
            }
        }
        return 0;
    }
}
