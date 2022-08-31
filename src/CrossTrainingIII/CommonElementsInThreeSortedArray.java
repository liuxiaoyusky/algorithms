package CrossTrainingIII;

import java.util.LinkedList;
import java.util.List;

/*
Find all common elements in 3 sorted arrays.

Assumptions

    The 3 given sorted arrays are not null
    There could be duplicate elements in each of the arrays

Examples

    A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]
 */
public class CommonElementsInThreeSortedArray {
    //move smallest element pointer
    public List<Integer> common(int[] a, int[] b, int[] c) {
        List<Integer> ans = new LinkedList<>();
        int al = 0;
        int bl = 0;
        int cl = 0;
        while (al < a.length && bl < b.length && cl < c.length) {
            if (a[al] == b[bl] && b[bl] == c[cl]) {
                ans.add(a[al]);
                al++;
                bl++;
                cl++;
            } else if (a[al] <= b[bl] && a[al] <= c[cl]) {
                al++;
            } else if (b[bl] <= a[al] && b[bl] <= c[cl]) {
                bl++;
            } else {
                cl++;
            }
        }

        return ans;
    }
}
