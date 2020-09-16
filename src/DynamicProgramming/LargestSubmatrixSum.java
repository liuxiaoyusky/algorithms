package DynamicProgramming;

public class LargestSubmatrixSum {
    /*
Given a matrix that contains integers, find the submatrix with the largest sum.
Return the sum of the submatrix.
Assumptions
The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
Examples
{ {1, -2, -1, 4},
  {1, -1,  1, 1},
  {0, -1, -1, 1},
  {0,  0,  1, 1} }
the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
     */
    //Time O(mn^2) space O(m)
    public int largest(int[][] matrix) {
        // assume M>=1,N>=1
        //basically, we need to go over every possible stubmatrix, and find their largest sum
        //we can find the largest sum in a group by comprass the matrix into array
        int result = matrix[0][0];
        int row = matrix.length;
        int column = matrix[0].length;

        //each group is the array comprassed from row i to row j, then find the max sum of the array
        for(int i=0;i<row;i++){
            int [] cur = new int [column];
            for(int j=i;j<row;j++){
                //comprass by add row j to cur
                add(cur,matrix[j]);
                int temp = findLargestSubarray(cur);
                result = Math.max(temp,result);
            }
        }
        return result;
    }

    private void add(int [] a, int [] b){
        for(int i=0;i<a.length;i++){
            a[i]+=b[i];
        }
    }

    private int findLargestSubarray(int [] array){
        int max = array[0];
        int cur = max;
        for(int i = 1;i<array.length;i++){
            cur = Math.max(cur+array[i],array[i]);
            max = Math.max(cur,max);
        }
        return max;
    }
}
