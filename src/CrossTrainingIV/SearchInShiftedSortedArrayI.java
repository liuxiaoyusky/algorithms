package CrossTrainingIV;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class SearchInShiftedSortedArrayI {
    //find shift number, covert back to normal array, and do bineary search
    public static int search(int[] array, int target) {
        int shift = findRightShiftNumber(array);
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int realMid = calculateIndex(mid, shift,array.length);
            if (array[realMid] == target) {
                return realMid;
            } else if (array[realMid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int findRightShiftNumber(int [] array) {
        //corner case
        if (array == null || array.length == 0) {
            return 0;
        }

        //find shift by finding first descending index, searching space[left, right]
        int left = 0;
        int right = array.length - 1;

        //shrink to two
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (array[left] < array[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        //calculate the shift number and return
        if(array[right] < array[left]) {
            return right;
        } else if(left != 0 && array[left - 1] > array[left]) {
            return left;
        } else {
            return 0;
        }

    }

    public static int calculateIndex(int cur, int rightShift, int arrayLength) {
        return (cur + rightShift) % arrayLength;
    }

    public static void main(String [] args) {
        int ans = search(new int[]{2,3,4}, 3);
    }
}
