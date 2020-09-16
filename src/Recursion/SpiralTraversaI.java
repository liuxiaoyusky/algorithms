package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversaI {
    public List<Integer> spiral(int[][] matrix) {
        //clarify: n>=0, array not null,n by n matrix
        List <Integer> ans=new ArrayList<>();

        int level=0;
        spiralTraverse(0,matrix.length,matrix, ans);
        return ans;
    }

    private void  spiralTraverse(int level, int size,int [][] matrix, List<Integer> ans){
        if(size==0){
            return;
        }
        if(size==1){
            ans.add(matrix[level][level]);
            return;
        }

        //top row,avoid the last one so won't be duplicated when go through right column
        for(int i=0;i<size-1;i++){
            ans.add(matrix[level][level+i]);
        }

        //right column, avoid right bottom corner
        for(int i=0;i<size-1;i++){
            ans.add(matrix[level+i][matrix.length-1-level]);
        }

        //bottom row,avoid left bottom corner
        for(int i=size-1;i>0;i--){
            ans.add(matrix[matrix.length-1-level][level+i]);
        }

        //left column,avoid left top corner
        for(int i=size-1;i>0;i--){
            ans.add(matrix[level+i][level]);
        }

        spiralTraverse(level+1,size-2,matrix,ans);
    }
}
