package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SprialTraversalII {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int rows=matrix.length;
        int columns=matrix[0].length;

        sprialTraverseII(0,rows,columns,matrix,ans);

        return ans;
    }
    private void sprialTraverseII(int level, int rows, int columns, int [][] matrix, List<Integer> ans){
        if(rows==0||columns==0){
            return;
        }else if(rows==1){
            for(int i=0;i<columns;i++){
                ans.add(matrix[level][level+i]);
            }
            return;
        }else if(columns==1){
            for(int i=0;i<rows;i++){
                ans.add(matrix[level+i][level]);
            }
            return;
        }

        //top row, avoid right top corner
        for(int i=0;i<columns-1;i++){
            ans.add(matrix[level][level+i]);
        }

        //right column, avoid right bottom corner
        for(int i=0;i<rows-1;i++){
            ans.add(matrix[level+i][matrix[0].length-1-level]);
        }

        //bottom row, avoid left bottom corner
        for(int i=columns-1;i>0;i--){
            ans.add(matrix[matrix.length-1-level][level+i]);
        }

        //left column, avoid left top corner
        for(int i=rows-1;i>0;i--){
            ans.add(matrix[level+i][level]);
        }


        sprialTraverseII(level+1,rows-2,columns-2,matrix,ans);
    }

    //------------------------------------------------------------------
    //solution2
    public List<Integer> sprialTraversalIISo2Iteration(int [][] matrix){
        List<Integer> ans=new ArrayList<>();
        int m=matrix.length;
        if(m==0){
            return ans;
        }
        int n=matrix[0].length;

        // location of the columns/rows
        int top=0;
        int right=n-1;
        int bottom=m-1;
        int left=0;

        while(left<right&&top<bottom){
            for(int i=left;i<right;i++){
                ans.add(matrix[top][i]);
            }
            for(int i=top;i<bottom;i++){
                ans.add(matrix[i][right]);
            }
            for(int i=right;i>left;i--){
                ans.add(matrix[bottom][i]);
            }
            for(int i=bottom;i>top;i--){
                ans.add(matrix[i][left]);
            }
            top++;
            right--;
            bottom--;
            left++;
        }

        //not columns or rows left
        if(left>right||top>bottom){
            return ans;
        }

        //one column left
        else if(left==right){
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][left]);
            }
            return ans;
        }

        //one row left
        else{
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            return ans;
        }
    }
}
