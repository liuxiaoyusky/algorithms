package DynamicProgramming.小班.RobotsMatrixProblems;

//What is the number of ways for a robot from top-left to bottom-right?
//ROBOT can only move right or down one cell
public class WaysToBottomRight {
    //solution 2: DP
    //definition: dp[i][j] = how many ways from [0,0] to [i, j]
    //induction rule: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    //result: dp[m - 1][n - 1]
    //base case: dp[0][j], dp[i][0]
    //time:O(mn) space:O(mn) -> only the top two lines are needed, so we can actually reduce to (2m or 2n)
    //-> we dont ever need top values after calculation, so we can reduce to (m or n)

    public int numOfWaysII(int m, int n) {
        //sanity check
        if (m <= 1 || n <= 1) {
            return 0;
        }

        //init
        //can reduce to Arrays.fill(dp, 1);
        int [] dp = new int [n];
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        for (int i = 1; i < m; i++) {
            //for new line
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }






    //-----------------------------------------------------------
    //solution 1: brute force: dfs3: for all path, if reaches the point, count++
    //time:O(2^(m+n)) space: O(m+n)
    public int numOfWays(int m, int n) {
        //sanity check
        if (m <= 1 || n <= 1) {
            return 0;
        }

        int [] counts = {0};
        findWays(0,0, m,n,counts);
        return counts[0];
    }

    private void findWays(int curI, int curJ, int maxI, int maxJ, int [] counts) {
        //base case
        if (curI >= maxI || curJ >= curJ) {
            return;
        }

        if (curI == maxI - 1 || curJ == maxJ - 1) {
            counts[0]++;
            return;
        }

        findWays(curI + 1, curJ, maxI, maxJ, counts);
        findWays(curI, curJ + 1, maxI, maxJ, counts);
    }
}
