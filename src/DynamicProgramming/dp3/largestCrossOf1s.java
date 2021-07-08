package DynamicProgramming.dp3;
/*
Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.

Return the arm length of the largest cross.

Assumptions

    The given matrix is not null, has size of N * M, N >= 0 and M >= 0.

Examples

{ {0, 0, 0, 0},

  {1, 1, 1, 1},

  {0, 1, 1, 1},

  {1, 0, 1, 1} }

the largest cross of 1s has arm length 2.
 */
public class largestCrossOf1s {
    public static int largest(int[][] matrix) {
        //corner case
        if (matrix == null) {
            return 0;
        }

        int m = matrix.length;
        if (m == 0) {
            return 0;
        }

        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }

        //prefix sum from left to right
        int [][] left_to_right = new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //base case for first column for each row
                if (j == 0) {
                    left_to_right [i][j] = matrix [i][j];
                }

                //normal case
                else if (matrix[i][j] == 1) {
                    left_to_right [i][j] = left_to_right [i][j - 1] + 1;
                }
            }
        }

        //prefix sum from right to left
        int [][] right_to_left = new int [m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //base case for last column for each row
                if (j == n - 1) {
                    right_to_left [i][j] = matrix [i][j];
                }

                //normal case
                else if (matrix[i][j] == 1) {
                    right_to_left [i][j] = right_to_left [i][j + 1] + 1;
                }
            }
        }

        //prefix sum from top to bottom
        int [][] top_to_bottom = new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //base case for first row
                if (i == 0) {
                    top_to_bottom [i][j] = matrix [i][j];
                }

                //normal case
                else if (matrix[i][j] == 1) {
                    top_to_bottom [i][j] = top_to_bottom [i - 1][j] + 1;
                }
            }
        }

        //prefix sum from bottom to top
        int [][] bottom_to_top = new int [m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //base case for last row
                if (i == m - 1) {
                    bottom_to_top [i][j] = matrix [i][j];
                }

                //normal case
                else if (matrix[i][j] == 1) {
                    bottom_to_top [i][j] = bottom_to_top [i + 1][j] + 1;
                }
            }
        }


        //go through each loc and find solution
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = Math.min(bottom_to_top [i][j], top_to_bottom [i][j]);
                int b = Math.min(left_to_right [i][j], right_to_left [i][j]);
                int cur = Math.min(a,b);
                max = Math.max(max,cur);
            }
        }

        return max;
    }

    public static void main(String [] args) {
        largest(new int[][] {{1,1,1,0,1},{1,0,1,1,1},{1,1,1,1,1},{1,0,1,1,0},{0,0,1,1,0}});
    }
}
