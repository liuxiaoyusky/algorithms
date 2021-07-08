package DynamicProgramming.dp4;
/*
Given an array A[0]...A[n-1] of integers, count the number of ascending subsequences.

In case that the result is larger than 32-bit integer, return the result in 10^9+7 modulo.

Assumptions

    A is not null

Examples
Input: A = {1,2,3}
Output: 7
Explanation: [1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]
 */
public class CountAscendingSubsequence {
    //num of permutations that is ascending
    //again can do it in dp. Each loc contains the ascending subsequence including current num
    public int numIncreasingSubsequences(int[] a) {
        // corner case
        if (a == null) {
            return 0;
        }

        int sum = 0;
        int [] count = new int [a.length];

        for (int i = 0; i < a.length; i++) {
            count[i] = 1; //itself
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    count[i] += count[j];
                }
            }
            sum += count[i];
        }

        return sum;
    }
}
