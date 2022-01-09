package CrossTrainingDIY;


import java.util.LinkedList;
import java.util.List;

public class TwoSumClosest {
    /*
    Find the pair of elements in a given array that sum to a value that is closest to the given target number.
    Return the values of the two numbers.
Assumptions
    The given array is not null and has length of at least 2
Examples
    A = {1, 4, 7, 13}, target = 7, closest pair is 1 + 7 = 8, return [1, 7].
     */

    public List<Integer> closest(int[] array, int target) {
        //need to discover all possible solutions unless we get exactly the number
        //clarify: in memory
        //assume: the sum of elements of arrays doesn't overflow
        //Time : O(n2) Space:O(1)
        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int cur = array[i] + array[j];
                cur = Math.abs(cur - target);
                if (cur < min) {
                    min = cur;
                    a = i;
                    b = j;
                }
            }
        }

        List<Integer> list = new LinkedList<>();
        list.add(array[a]);
        list.add(array[b]);
        return list;
    }
}
