package CrossTrainingI;
/*
Rotate an N * N matrix clockwise 90 degrees.
Assumptions
The matrix is not null and N >= 0
Examples
{ {1,  2,  3}
  {8,  9,  4},
  {7,  6,  5} }
after rotation is
{ {7,  8,  1}
  {6,  9,  2},
  {5,  4,  3} }
 */

public class RotateMatrix {
//Solution 2: mirror the point accroding to y axis, then mirror the point according the line of y = x
//Time: O(n) Space O(1)
    public void rotateII(int [][] matrix){
        int n = matrix.length;
        if(n<=1){
            return;
        }
        mirrorY(matrix,n);
        mirrorYEX(matrix,n);
    }
    private void mirrorY(int [][]matrix,int n){
        for(int i = 0;i<n;i++){
            for (int j=0;j<n/2;j++){
                swap(matrix, i,j,i,n-1-j);
            }
        }
    }

    private void mirrorYEX(int [][]matrix, int n){
        for(int i =0;i<n;i++){
            for(int j=0;j+i<n-1;j++){
                swap(matrix,i,j,n-1-j,n-1-i);
            }
        }
    }
    private void swap(int [][]matrix, int i, int j, int a, int b){
        int temp = matrix[i][j];
        matrix [i][j] = matrix [a][b];
        matrix [a][b] = temp;
    }
//Solution 1: do it directly. Time O(n) Space O(1)
    public void rotate(int[][] matrix) {
        // assume not null and N>=0 row,column
        int N = matrix.length;
        if(N<=1){
            return;
        }
        int round = N/2;
        for(int level=0; level<round; level++){
            int left = level;
            int right = N-2-level;
            for(int i = left; i<=right;i++){
                int temp = matrix[left][i];//00
                matrix[left][i] = matrix [N-1-i][left];//top row = left column
                matrix [N-1-i][left] = matrix [N-1-left][N-1-i];//left column = bottom row
                matrix [N-1-left][N-1-i] = matrix [i][N-1-left];// bottom row = right column
                matrix[i][N-1-left] = temp;//right column = top row
            }
        }
    }
}
