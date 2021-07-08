package DynamicProgramming.dp3;

import javax.swing.*;

public class LargestSquareOfMatches {
    //transfer this to two matrix, one up and down, one left to right
    //use prefix sum to find the length from left to right and up to down
    //at each location, find the min of bottom and right + 1 ans the max length of sizes, then try find the pairs
    //different from previous, 边长是两坐标的差值，而不是差值+1
    //input matrix, output int
    //正方形必须四个边都是match，也就是说如果有一个2*3长方形和1*1正方形的，答案是1*1
    public static int largestSquareOfMatches(int[][] matrix) {
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

        //two prefix sum matrix
        int [][] right_to_left = new int [m + 1][n + 1];//avoid corner case on right most and bottom most
        int [][] bottom_to_top = new int [m + 1][n + 1];//avoid corner case on right most and bottom most

        int max = 0;
        int cur = 0;
        //go through each loc from rightBottom to leftTop, whenever reach a 3, check square
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == 1) {//row
                    right_to_left[i][j] = right_to_left[i][j + 1] + 1;
                } else if (matrix [i][j] == 2) {//column
                    bottom_to_top[i][j] = bottom_to_top[i + 1][j] + 1;
                } else if (matrix[i][j] == 3) { // a corner, check square
                    right_to_left[i][j] = right_to_left[i][j + 1] + 1;
                    bottom_to_top[i][j] = bottom_to_top[i + 1][j] + 1;
                    //check right and bottom
                    cur = Math.min(right_to_left[i][j],bottom_to_top[i][j]);
                    for (int k = cur; k > max; k--) {
                        if (right_to_left[i + k][j] >= cur && bottom_to_top[i][j + k] >= cur) {
                            max = cur;
                            break;
                        } else {
                            cur--;
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String [] args) {
        int k = largestSquareOfMatches(new int[][]
                {{1,3,2},{2,3,2},{3,3,2},{3,3,2},{3,2,2},{1,2,2},{1,3,2},{0,1,0}});
        System.out.println(k);
    }
}
