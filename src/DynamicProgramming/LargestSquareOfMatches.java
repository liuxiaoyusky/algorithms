package DynamicProgramming;

public class LargestSquareOfMatches {
    public int largestSquareOfMatches(int[][] matrix) {
        // assume m>=0,n>=0
        int ans = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;

        //at least 2 rows or 2 columns to construst a square
        if(rows<2 || columns<2){
            return ans;
        }

        //to avoid the corner case when i=0 or j=0,shift each cell to right bottom with 1
        int [][] leftRight = new int [rows+1][columns+1];
        int [][] upDown = new int [rows+1][columns+1];

        //prefix sum
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns;j++){
                if(matrix[i][j]==1){
                    leftRight[i+1][j+1] = leftRight[i+1][j]+1;
                }else if(matrix[i][j]==2){
                    upDown[i+1][j+1] = upDown[i][j+1]+1;
                }else if(matrix[i][j]==3){
                    leftRight[i+1][j+1] = leftRight[i+1][j]+1;
                    upDown[i+1][j+1] = upDown[i][j+1]+1;
                }

                //if bottom and right are larger than ans, try update from largest possiblity to smaller one
                int maxLength = Math.min(leftRight[i+1][j+1],upDown[i+1][j+1]);
                if(maxLength>ans){
                    for(int k = maxLength;k>ans;k--){
                        //check top
                        boolean top=false;
                        for(int x=upDown[i+1][j+1]; x>=k; x--){
                            if(leftRight[i+1-x][j+1]>ans){
                                top=true;
                                break;
                            }
                        }

                        boolean left=false;
                        for(int y=leftRight[i+1][j+1];y>=k;y--){
                            if(upDown[i+1][j+1-y]>ans){
                                left=true;
                                break;
                            }
                        }

                        if(left && top){
                            ans=Math.max(k,ans);
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
