package DynamicProgrammingIV;

public class CanIWinII {
    //do it by recursion, every time we select, we got two choices and try each one by turns
    //every time the other side make choice, choose the larger one for sure
    //if select i, lose max[i + 1, j]
    //if select j, lose max[i, j - 1]
    //until no more element in [i,j] => j > j

    //to save time: we can use 2d [][]dp, dp[i][j]
    //reprensenting the max value I got when I can pick from [i,j]
    public int canWin(int[] nums) {
        int n = nums.length;
        int [][][] dp = new int [n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    dp[i][i][0] = nums[i];//0 == I pick first
                    continue;
                }

                //in general
                dp[j][i][0] = Math.max(nums[j] + dp[j + 1][i][1], nums[i] + dp[j][i - 1][1]);
                dp[j][i][1] = nums[j] >= nums[i] ? dp[j + 1][i][0] : dp[j][i - 1][0];
            }
        }

        return dp[0][n - 1][0];
    }
}
