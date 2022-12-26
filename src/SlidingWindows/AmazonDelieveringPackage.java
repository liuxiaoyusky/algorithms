package SlidingWindows;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
find the max value of k consecutive packages that each has distinct value
 */
public class AmazonDelieveringPackage {
    public int findPackages(int [] array, int k) {
        //corner case
        if (array == null || k < 0 || array.length < k) {
            return -1;
        }

        int start = 0;
        int sum = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();

        for (int end = 0; end < array.length; end++) {
            int val = array[end];
            //xxxxxVALxxxxxxEND
            while (set.contains(val) || start + k - 1 > end) {
                sum -= val;
                set.remove(array[start++]);
            }

            sum += val;
            set.add(val);

            if (end - start + 1 == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
