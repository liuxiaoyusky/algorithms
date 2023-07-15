package DynamicProgramming.小班;

import java.util.Map;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
public class CutWood {
    public int minCost(int [] num, int L) {
        //sanity check
        if (num == null || num.length == 0 || L <= 0) {
            return 0;
        }

        int [] arr = prependAndAppend(num, L);
        int n = arr.length;
        int [][] dp = new int [n][n];

        //base case: skip
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], arr[j] - arr[i] + dp[i][k] + dp[k][j]);
                }
            }
        }

        return dp[0][n - 1];
    }

    private int [] prependAndAppend(int [] nums, int L) {
        int [] arr = new int[nums.length + 2];
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = nums[i - 1];
        }

        arr[arr.length - 1] = L;
        return arr;
    }
}
