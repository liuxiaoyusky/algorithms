package CrossTrainingIII;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
Find all common elements in K sorted lists.


Assumptions

The input and its elements are not null, and support fast random access.

There could be duplicate elements in each of the lists.


Examples

Input = {{1, 2, 2, 3}, {2, 2, 3, 5}, {2, 2, 4}}, the common elements are {2, 2}.
 */
public class CommonElementsInKSortedLists {
    //compare every two list at once, easy implementation
    public List<Integer> commonElementsInKSortedArraysI(List<List<Integer>> input) {
        List<Integer> ans = input.remove(0);
        for (List<Integer> list: input) {
            if (ans.size() == 0) {
                return ans;
            }

            ans = findCommon(ans, list);
        }
        return ans;
    }

    private List<Integer> findCommon(List<Integer> cur, List<Integer> list) {
        int a = 0;
        int b = 0;
        List<Integer> sol = new LinkedList<>();
        while (a < cur.size() && b < list.size()) {
            if (cur.get(a) == list.get(b)) {
                sol.add(cur.get(a));
                a++;
                b++;
            } else if (cur.get(a) < list.get(b)) {
                a++;
            } else {
                b++;
            }
        }
        return sol;
    }
    //---------------------------------------------------
//maintian a min pq with one element from each list's front
    //keep track of largest element max, if pq.peek == max, add it to output
    //nlogk where n is the total length of all lists

    class Element {
        int value;
        int listIndex;
        int elementIndex;
        public Element(int listIndex, int elementIndex, int value) {
            this.value = value;
            this.elementIndex = elementIndex;
            this.listIndex = listIndex;
        }
    }

    class MyComparator implements Comparator<Element> {
        public int compare(Element o1, Element o2) {
            if (o1.value == o2.value) {
                return 0;
            }
            return o1.value < o2.value ? -1 : 1;
        }
    }

    public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
        List<Integer> ans = new LinkedList<>();
        int k = input.size();
        if (k == 0) {
            return ans;
        }
        PriorityQueue<Element> pq = new PriorityQueue<>(k, new MyComparator());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int curValue = input.get(i).get(0);
            pq.offer(new Element(i, 0, curValue));
            max = Math.max(max, curValue);
        }

        //go find the same value, if smallest == amx
        while (pq.size() == k) {
            Element cur = pq.poll();
            if (cur.value == max) {
                ans.add(max);
                //advance all element by 1 index, and update max
                pq.offer(cur);
                max = updatePQ(pq, input);
            } else {
                //advance current element by 1 index
                cur = updateE(cur, input);
                if (cur != null) {
                    //if not null, update max
                    pq.offer(cur);
                    max = Math.max(max, cur.value);
                } else {
                    //reaches the end of one lists, stop searching
                    break;
                }
            }
        }
        return ans;
    }

    private int updatePQ(PriorityQueue<Element> pq, List<List<Integer>> input) {
        List<Element> arr = new LinkedList<>();
        while (!pq.isEmpty()) {
            arr.add(pq.poll());
        }

        int max = Integer.MIN_VALUE;
        for(Element e : arr) {
            e = updateE(e,input);
            if (e == null) {
                break;
            }
            max = Math.max(max, e.value);
            pq.offer(e);
        }

        return max;
    }

    private Element updateE(Element e, List<List<Integer>> input) {
        int listIndex = e.listIndex;
        int elementIndex = e.elementIndex + 1;
        if (elementIndex < input.get(listIndex).size()) {
            e.elementIndex = elementIndex;
            e.value = input.get(listIndex).get(elementIndex);
        }
        else {
            e = null;
        }
        return e;
    }
}
