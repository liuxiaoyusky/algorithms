package CrossTrainingIV.prep;

import java.util.HashMap;
import java.util.Map;

public class MajorityNumberI {
    public int majority(int [] array) {
        int count = 0;
        int ans = array[0];
        for (int i : array) {
            if (count == 0) {
                count = 1;
                ans = i;
            } else {
                if (ans == i) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return ans;
    }

    //solution 2
    public int majorityII(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            Integer count = map.get(i);
            if (count == null) {
                count = 0;
            }

            count++;
            map.put(i, count);
        }

        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (e.getValue() > array.length / 2) {
                return e.getKey();
            }
        }

        return -1;
    }
}
