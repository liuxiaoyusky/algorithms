package CrossTrainingIII;

import java.util.*;

/*
Find all numbers that appear in both of two unsorted arrays.

Assumptions

    Both of the two arrays are not null.
    In any of the two arrays, there could be duplicate numbers.

Examples

    A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)
 */
public class CommonNumbersOfTwoArraysII {
    public List<Integer> common(int[] A, int[] B) {
        // clarify: with dup, not null, not sorted
        // assume: A is shorter, return in ascending order
        List<Integer> res = new ArrayList<>();
        if (A.length == 0 || B.length == 0) {
            return res;
        }

        //hashMap the shorter one, assumed A
        Map<Integer,Integer> map = toMap(A);

        //check common in B
        for (int cur : B) {
            Integer count = map.get(cur);
            if (count == null || count < 1) {
                continue;
            } else {
                res.add(cur);
                map.put(cur, count - 1);
            }
        }
        //return res
        Collections.sort(res);
        return res;
    }

    private Map<Integer,Integer> toMap (int [] array) {
        Map <Integer,Integer> map = new HashMap<>();
        for (int cur : array) {
            Integer count = map.get(cur);
            if (count == null) {
                map.put(cur, 1);;
            } else {
                map.put(cur, count + 1);
            }
        }
        return map;
    }
}
