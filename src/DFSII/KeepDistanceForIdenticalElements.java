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
    public static int[] keepDistance(int k) {
        int [] ans = new int[2 * k];
        Set<Integer> used = new HashSet<>();
        boolean [] satisfied = new boolean [1];
        helper(k, used, ans, 0, satisfied);
        return satisfied[0] ? ans : null;
    }

    private static void helper(int k, Set<Integer> used,int [] ans, int index, boolean [] satisfied) {
        //base case
        if (satisfied[0] || index == ans.length) {
            satisfied[0] = true;
            return;
        }

        //already filled number
        if (ans[index] != 0) {
            helper(k, used, ans, index + 1, satisfied);
            return;
        }

        for (int i = 1; i <= k; i++) {
            if(used.contains(i)) {
                continue;
            }
            int nextIndex = i + 1 + index;
            if (nextIndex < ans.length && ans[nextIndex] == 0) {
                ans[index] = i;
                ans[nextIndex] = i;
                used.add(i);
                helper(k, used, ans, index + 1, satisfied);


                //backtrack
                if (!satisfied[0]) {
                    ans[index] = 0;
                    ans[nextIndex] = 0;
                    used.remove(i);
                } else {
                    break;
                }
            }
        }
    }
}