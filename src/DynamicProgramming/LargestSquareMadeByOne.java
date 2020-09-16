package DynamicProgramming;

//diy question and answer,need to test later
public class LargestSquareMadeByOne {
    public int LargestSquareMadeByOne(int[][] matrix) {
        //assume not null, and m,n>0
        int row = matrix.length;
        int column = matrix[0].length;
        int [][] leftToRight = new int [row+1][column+1];//in case of out of bound, +1
        int result = 0;
        for(int i = 0; i<row;i++){
            for(int j = 0; j<column; j++){
                if(matrix[i][j]==1){
                    //check square if cur>result
                    int cur = leftToRight[i+1][j] + 1;
                    leftToRight[i+1][j+1] = cur;
                    if(cur>result){
                        //possible answer, check the upper cur-2 rows, break if out of bound or there is a shortter row
                        boolean flag = true;
                        for(int k = cur-1;k>0;k--){
                            if(i+1<k||leftToRight[i-k+1][j+1]<leftToRight[i+1][j+1]){
                                flag = false;
                                break;
                            }
                        }
                        //complete larger square, update teh answer
                        if(flag){
                            result = Math.max(result,cur);
                        }
                    }
                }
            }
        }

        return result;
    }
}
