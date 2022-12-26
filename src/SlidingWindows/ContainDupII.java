package SlidingWindows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//check if given array has dup elements where two indices i and j are abs(i - j) <= k
public class ContainDupII {
    //fix one, check the other

    //solution 1: check distance of fixed value: use a map save most recent element
    //time: O(n), space:O(n)
    public boolean checkDup(int [] array, int k) {
        if (array == null || array.length < 2 || k == 0) {
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
    //time:O(n), space:O(k)
    public boolean checkDupII(int [] array, int k) {
        if (array == null || array.length < 2 || k == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();//saves k elements

        for (int i = 0; i < array.length; i++) {
            if (!set.add(array[i])) {
                return true;
            }

            if (i >= k) {
                set.remove(array[i - k]);
            }
        }
        return false;
    }
}
