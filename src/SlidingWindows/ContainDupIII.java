package SlidingWindows;

import java.util.*;

//check if given array has elements
// where two indices i and j are abs(i - j) <= k
// and values are abs(num[i] - num[j]) <= valueDiff
public class ContainDupIII {
    //fix one, check the other

    //solution 1: check distance of fixed value: use a map save most recent element
    //time: O(n), space:O(k)
    public boolean checkDup(int [] array, int k, int valueDiff) {
        if (array == null || array.length < 2 || k == 0 || valueDiff < 0) {
            return false;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer last = map.get(array[i]);
            if (last == null) {
                continue;
            } else {
                if (i - last <= k) {
                    return true;
                }
            }
            map.put(i,i);
        }
        return false;
    }

    //solution 2: fix distance, check dup
    //time:O(nlogk), space:O(k)
    public boolean checkDupII(int [] array, int k, int valueDiff) {
        if (array == null || array.length < 2 || k == 0 || valueDiff < 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();//saves k elements

        for (int i = 0; i < array.length; i++) {
            int bucketIndex = getBucketIndex(array,i, valueDiff);
            if (map.put(bucketIndex, array[i]) != null) {
                return true;
            }

            Integer left = map.get(bucketIndex - 1);
            if (left != null && array[i] - left <= valueDiff) {
                return true;
            }

            Integer right = map.get(bucketIndex + 1);
            if (right != null && right - array[i] <= valueDiff) {
                return true;
            }

            if (i >= k) {
                map.remove(getBucketIndex(array, i - k, valueDiff));
            }
        }
        return false;
    }

    private int getBucketIndex(int [] array, int i, int valueDiff) {
        return array[i] < 0 ? array[i] / (valueDiff + 1) - 1 : array[i] / (valueDiff + 1);
    }
}
