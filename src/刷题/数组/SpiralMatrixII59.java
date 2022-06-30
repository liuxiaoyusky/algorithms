package 刷题.数组;
/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
Input: n = 1
Output: [[1]]

Constraints:
    1 <= n <= 20
 */
public class SpiralMatrixII59 {
    //input:n, output:int [][]
    //for top row:left to right:at ith layer:[(i,i) -> (i,n - 2 - i)]
    //for right column: [(i,n - 1 - i) -> (n - 2 - i, n - 1 - i)]
    //for bottom row: right to left: [(n - 1 - i, n - 1 - i) ->  (n - 1 - i, i + 1)]
    //for left column: [(n - 1 - i, i) -> (i + 1, i)]
    //there are n / 2 layer
    //if n % 2 == 1, put the last value in the center
    public int[][] generateMatrix(int n) {
        int [][] m = new int[n][n];

        int cur = 1;
        for(int i = 0; i < n / 2; i++) {
            for (int j = i; j <= n - 2 - i; j++) {
                m[i][j] = cur++;
            }

            for (int j = i; j <= n - 2 - i; j++) {
                m[j][n - 1 - i] = cur++;
            }

            for (int j = n - i - 1; j >= i + 1; j--) {
                m[n - 1 - i][j] = cur++;
            }

            for (int j = n - 1 - i; j >= i + 1; j--) {
                m[j][i] = cur++;
            }
        }
        if (n % 2 == 1) {
            m[n / 2] [n / 2] = cur;
        }
        return m;
    }
}
