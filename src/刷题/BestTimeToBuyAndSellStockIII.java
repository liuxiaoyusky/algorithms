package 刷题;

import java.util.LinkedList;
import java.util.List;

public class BestTimeToBuyAndSellStockIII {
    //find all non-descending subsequence, with the largest difference, mark their starting value and ending value
    //from left to right, track the lowest and largest and save in left[i], meaning the longest subsequece for first
    //i sequence

    //from right to left, track the lowest and largest and save in right[i], meaning the longest subsequence for last i sequence
    //find the max for sum of left and right part

    public int maxProfit(int[] prices) {
        int [][][] dp = new int [prices.length][3][2];//ikj
        //for j: j = 0, no stock on hand
        //      j = 1, stock on hand

        //for k: k = buys upper limit
        //set impossible actions to -infinity
        for (int i = 0; i < prices.length; i++) {//day
            for (int k = 0; k < 3; k++) {
                if (k == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = Integer.MIN_VALUE;
                    continue;
                } else if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                    continue;
                }

                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);//sell
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);//buy
            }
        }

        return dp[prices.length - 1][2][0];
    }
}
