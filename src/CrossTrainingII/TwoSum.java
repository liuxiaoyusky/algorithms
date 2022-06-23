package CrossTrainingII;

import java.util.HashSet;
import java.util.Set;

/*
Determine if there exist two elements in a given array, the sum of which is the given target number.

Assumptions

    The given array is not null and has length of at least 2

​Examples

    A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)

    A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)

    A = {2, 4, 1}, target = 4, return false
 */

public class TwoSum {
    //time: n space:n
    public boolean existSum(int[] array, int target) {
        //given array not null, array.legnth >= 2
        //Hashset
        Set<Integer> set = new HashSet<>();
        for (int cur : array) {
            if (set.contains(target - cur)) {
                return true;
            } else {
                set.add(cur);
            }
        }
        return false;
    }

    //solution 2
    //time:n space:1
    //if array is sorted in ascending order, we can do it in place
    public boolean existSumII (int [] array, int target) {
        int left = 0;
        int right = array.length - 1;

        //assume same element cannot use twice
        //check array[left] + array[right] == target
        while (left < right) {
            if (array[left] + array[right] == target) {
                return true;
            } else if (array[left] + array[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}