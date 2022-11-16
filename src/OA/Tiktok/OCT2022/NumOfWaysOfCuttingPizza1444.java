package OA.Tiktok.OCT2022;

public class NumOfWaysOfCuttingPizza1444 {
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        //dp means if k more slices need to be done, with mn(right bottom) pizza left
        int [][][] dp = new int [k][m][n];//k means slices need to be done
        int [][] prefixSum = makePrefixSum(pizza);

        for (int cut = 0; cut < k; cut++) {
            for (int i = 0; i < dp[0].length; i++) {
                for (int j = 0; j < dp[0][0].length; j++) {
                    //no need to cut, need 1 pizza
                    if (cut == 0) {
                        dp[cut][i][j] = prefixSum[i][j] > 0 ? 1 : 0;
                        continue;
                    }

                    //given pizza[i][j], can we cut one more time to get two pizza, top at least 1,
                    //bottom at least k-1 cut and k apple left
                    //cut horizontal
                    for (int row = i + 1; row < dp[0].length; row++) {
                        int top = prefixSum[i][j] - prefixSum[row][j];
                        int bottom = prefixSum[row][j];
                        //valid cut
                        if (top > 0 && bottom >= cut) {
                            dp[cut][i][j] += dp[cut - 1][row][j];
                            dp[cut][i][j] %= 1_000_000_007;
                        }
                    }

                    //cor vertical
                    for (int col = j + 1; col < dp[0][0].length; col++) {
                        int left = prefixSum[i][j] - prefixSum[i][col];
                        int right = prefixSum[i][col];
                        //valid cut
                        if (left > 0 && right >= cut) {
                            dp[cut][i][j] += dp[cut - 1][i][col];
                            dp[cut][i][j] %= 1_000_000_007;
                        }
                    }
                }
            }
        }
        return dp[k - 1][0][0];
    }

    private int [][] makePrefixSum(String [] pizza) {
        int m = pizza.length;
        int n = pizza[0].length();
        int [][] prefixSum = new int [m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            char [] array = pizza[i].toCharArray();
            for (int j = n - 1; j >= 0; j--) {
                prefixSum[i][j] = prefixSum[i + 1][j] + prefixSum[i][j + 1] - prefixSum[i + 1][j + 1];
                char c = array[j];
                if (c == 'A') {
                    prefixSum[i][j]++;
                }
            }
        }
        return prefixSum;
    }
}
