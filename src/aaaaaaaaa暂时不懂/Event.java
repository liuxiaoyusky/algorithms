package aaaaaaaaa暂时不懂;

import java.util.*;

public class Event {
    //input: int array, int k
    //output: top k most common element
    class RT implements Comparable<RT>{
        int value;
        int frequency;
        public RT(int v, int f) {
            this.value = v;
            this.frequency = f;
        }

        public int compareTo(RT o) {
            if (frequency == o.frequency) {
                return value - o.value;
            }
            return frequency < o.frequency ? -1 : 1;
        }
    }

    public List<Integer> findMostKFrequency(int [] array, int k) {
        List<Integer> ans = new ArrayList<>(k);
        Map<Integer, RT> map = new HashMap<Integer, RT>();
        for (int num : array) {
            RT cur = map.get(num);
            if (cur == null) {
                cur = new RT(num, 0);
            }
            cur.frequency++;
            map.put(num, cur);
        }

        PriorityQueue<RT> pq = new PriorityQueue<>(k + 1);
        for (RT rt: map.values()){
            if (pq.size() < k) {
                pq.add(rt);
            }

            else {
                pq.add(rt);
                pq.poll();
            }
        }

        for (RT rt : pq){
            ans.add(rt.value);
        }

        return ans;

    }
}
