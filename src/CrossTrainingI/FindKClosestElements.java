package CrossTrainingI;

import java.util.PriorityQueue;

public class FindKClosestElements {
    /*
     * @param a: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */

    class Element implements Comparable<Element> {
        int value;
        int difference;
        Element(int v, int d) {
            this.value = v;
            this.difference = d;
        }

        public int compareTo(Element o) {
            if (o.difference == this.difference){
                return Integer.compare(o.value, this.value);
            }
            return Integer.compare(o.difference, this.difference);
        }
    }
    public int[] kClosestNumbers(int[] a, int target, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for(int num : a) {
            pq.add(new Element(num, Math.abs(target - num)));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int [] ans = new int [k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll().value;
        }
        return ans;
    }
}