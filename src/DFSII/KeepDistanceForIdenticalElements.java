package DFSII;

import java.util.HashSet;
import java.util.Set;

/*
Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k], such that the output
integer array satisfy this condition:
Between each two i's, they are exactly i integers (for example: between the two 1s, there is one number, between the two
 2's there are two numbers).
If there does not exist such sequence, return null.
Assumptions:
    k is guaranteed to be > 0
Examples:
    k = 3, The output = { 2, 3, 1, 2, 1, 3 }.
 */
public class KeepDistanceForIdenticalElements {
    //do it in dfs
    public static int[] keepDistance(int k) {
        // Write your solution here.
        int [] ans = new int [2 * k];
        boolean [] bool = new boolean[] {false};
        Set<Integer> set = new HashSet<>();
        helper(ans, 0, k, set, bool);

        //return ans
        if (bool[0]) {
            return ans;
        } else {
            return null;
        }
    }

    private static void helper(int [] ans, int index, int k, Set<Integer> set, boolean [] bool) {
        //base case
        if (set.size() == k) {
            bool[0] = true;
            return;
        } else if (bool[0]) {
            return;
        }

        //find a int for current index
        for (int i = 1; i <= k; i++) {
            if (set.contains(i)) {
                continue;
            }

            if (index + 1 + i < (2 * k) && ans[index + 1 + i] == 0) {
                ans[index] = i;
                ans[index + 1 + i] = i;
                int next = index + 1;
                set.add(i);
                while (next < (2 * k) && (ans[next] != 0)) {
                    next++;
                }
                helper(ans, next, k, set, bool);
                if (bool[0]) {
                    return;
                }

                //back track
                ans[index] = 0;
                ans[index + 1 + i] = 0;
                set.remove(i);
            }
        }


    }
}