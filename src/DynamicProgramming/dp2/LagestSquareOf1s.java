package DynamicProgramming.dp2;
/*
Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.

Assumptions

    The given matrix is not null and guaranteed to be of size N * N, N >= 0

Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1}}

the largest square of 1s has length of 2
 */
public class LagestSquareOf1s {
    //rule: since looking for square, we update the current loc iff matrix[loc] = 1, value = min[up + 1, left + 1, left up + 1];
    //base case: loc on top or left
    public int largest(int[][] matrix) {
        int n = matrix.length;

        //corner case
        if (n == 0) {
            return 0;
        }

        //track the global maximum square
        int result = 0;

        int ans[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //for first row and column (most top and left)
                if (i == 0 || j == 0) {
                    ans[i][j] = matrix[i][j];
                }
                //general case, follow the rule
                else if (matrix[i][j] == 1) {
                    //for the rest of the matrix which value is 1, find the minimum sides
                    ans[i][j] = Math.min(ans[i - 1][j] + 1, ans[i][j - 1] + 1);
                    ans[i][j] = Math.min(ans[i][j], ans[i - 1][j - 1] + 1);
                }
                result = Math.max(result, ans[i][j]);
            }
        }
        return result;
    }
}
