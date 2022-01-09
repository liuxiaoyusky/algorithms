package CrossTrainingDIY;

import java.util.PriorityQueue;

/*
We have a list of piles of stones, each pile of stones has a certain weight, represented by an array of integers. In each move, we can merge two adjacent piles into one larger pile, the cost is the sum of the weights of the two piles. We merge the piles of stones until we have only one pile left. Determine the minimum total cost.

Assumptions

    stones is not null and is length of at least 1

Examples

{4, 3, 3, 4}, the minimum cost is 28

    merge first 4 and first 3, cost 7

    merge second 3 and second 4, cost 7

    merge two 7s, cost 14

    total cost = 7 + 7 + 14 = 28
 */
//do it by dp
//dp[i][j] means the minimum cost to merge stone i to stone j, either dp[i-1][j] + cost, or dp[i][j - 1] + cost
public class MergeStones {
    public static int mergeStones(int [] stones) {
        int n = stones.length;
        int [][] minCost = new int[n][n];
        //use prefix sum for pure cost to merge
        int [] prefix = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = stones[i] + prefix[i - 1];
        }


        /*
        1324
        0
        4  0
        10 5  0
        20 14 6 0
         */

        //symmetric about i = j, when i = j, cost = 0, let i >= j
        for (int i = 0; i < stones.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                //base case
                if (i - j == 1) {
                    minCost[i][j] = stones[i] + stones[j];
                }

                else {
                    int cost = prefix[i] - prefix[j] + stones[j];
                    int minSum = Integer.MAX_VALUE;//20 = min(10,21)
                    //try all combination for merge i to j
                    for (int k = 0; k < i - j; k++) {
                        minSum = Math.min(minSum, minCost[i][i - k] + minCost[i - k - 1][j]);//30 = 32 + 00
                    }
                    minCost[i][j] = minSum + cost;
                }
            }
        }

        return minCost[n - 1][0];
    }
}
