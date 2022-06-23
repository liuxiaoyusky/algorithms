package Atlas;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//assume K <= N, N >= 0
//assume unsorted array
//naive way: sort and take k largest. Time: O(nlogn) Space:(n)
//updated: use a heap to maintain k largest number. Time: O(nlogk) Space: O(k)
public class KLargestNumbers {
    public int[] kLargest(int[] array, int k) {
        //corner case
        int [] res = new int [k];
        if (k == 0) {
            return res;
        }
        Queue<Integer> ans = new PriorityQueue<Integer>();
        for (int cur : array) {
            if (ans.size() < k) {
                ans.offer(cur);
            } else {
                Integer temp = ans.peek();
                if (cur < temp) {
                    ans.poll();
                    ans.offer(cur);
                }
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            res[i] = ans.poll();
        }
        return res;
    }
}
