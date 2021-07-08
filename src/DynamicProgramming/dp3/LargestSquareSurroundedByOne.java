package DynamicProgramming.dp3;
/*
Determine the largest square surrounded by 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.


Assumptions

The given matrix is guaranteed to be of size M * N, where M, N >= 0


Examples

{{1, 0, 1, 1, 1},

 {1, 1, 1, 1, 1},

 {1, 1, 0, 1, 0},

 {1, 1, 1, 1, 1},

 {1, 1, 1, 0, 0}}


The largest square surrounded by 1s has length of 3.
 */
public class LargestSquareSurroundedByOne {
    //to help solve the problem, we have prefix sum matrix
    //rule, for each loc, it has the consecutive length on bottom and right
    //after determine the length of the side, we can try find the length on top and left
    public int largestSquareSurroundedByOne(int[][] matrix) {
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

        //prefix sum for matrix from left to right
        int [][] left_to_right = new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //base case, first column in each row
                if (j == 0) {
                    left_to_right [i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    left_to_right [i][j] = left_to_right[i][j - 1] + 1;
                }
                //else, matrix[i][j] == 0 => left_to_right [i][j] = 0
            }
        }

        //prefix sum for matrix from top to bottom
        int [][] top_to_buttom = new int [m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //base case, first row
                if (i == 0) {
                    top_to_buttom [i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    top_to_buttom [i][j] = top_to_buttom[i - 1][j] + 1;
                }
                //else, matrix[i][j] == 0 => top_to_buttom [i][j] = 0
            }
        }

        //go through each loc by rule and find max square
        int globalMax = 0;
        int curLengthOfSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curLengthOfSide = Math.min(left_to_right[i][j], top_to_buttom[i][j]);
                //start from max length, try find a larger square than current one
                while (curLengthOfSide > globalMax) {
                    //check if out of bound
                    int indexOfLeft = j - curLengthOfSide + 1;
                    int indexOfTop = i - curLengthOfSide + 1;

                    //corner case
                    if (indexOfLeft < 0 || indexOfTop < 0) {
                        curLengthOfSide--;
                        continue;
                    }

                    //check length
                    if(left_to_right[indexOfTop][j] < curLengthOfSide || top_to_buttom[i][indexOfLeft] < curLengthOfSide) {
                        curLengthOfSide--;
                        continue;
                    }

                    //update maxLength
                    globalMax = curLengthOfSide;
                    break;
                }
            }
        }

        return globalMax;
    }
}
