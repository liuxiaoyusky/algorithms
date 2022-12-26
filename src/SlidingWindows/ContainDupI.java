package SlidingWindows;

import java.util.HashSet;
import java.util.Set;

//check if given array has dup elements
public class ContainDupI {
    public boolean checkDup(int [] array) {
        if (array == null || array.length < 2) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
