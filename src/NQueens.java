import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> cur=new ArrayList<Integer>();
        helper(n,cur,result);
        return result;
    }

    private void helper(int n,List<Integer> cur,List<List<Integer>> result){
        if(cur.size()==n){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=0;i<n;i++){
            //check if putting a queen at column i at current row is valid
            if(valid(cur,i)){
                cur.add(i);
                helper(n,cur,result);
                cur.remove(cur.size()-1);
            }
        }
    }
    private boolean valid(List<Integer> cur,int column){
        int row=cur.size();
        for(int i=0;i<row;i++){
//for each row: same column ||  same diagonal(difference of rows are the same as difference of columns)
            if(cur.get(i)==column||Math.abs(cur.get(i)-column)==row-i){
                return false;
            }
        }
        return true;
    }

    //----------------------------------------------------------------------------------
    //second method total time O(n)
    public List<List<Integer>> nqueensII(int n){
        List<List<Integer>> result=new ArrayList<>();
        boolean[]column =new boolean [n];
        boolean[]diagonal=new boolean[2*n-1];
        boolean[]revDiagonal=new boolean [2*n-1];

        int []cur=new int [n];
        helper2(result,column,diagonal,revDiagonal,0,n,cur);

        return result;
    }

    private void helper2(List<List<Integer>> result,boolean []column,boolean []diagonal,boolean [] revDiagonal,int row,int n,int [] cur){
        if(row==n){
            result.add(toList(cur));
        }
        for(int i=0;i<n;i++){
            if(valid(n,row,i,column,diagonal,revDiagonal)){
                mark(n,row,i,column,diagonal,revDiagonal);
                cur[row]=i;
                helper2(result,column,diagonal,revDiagonal,row+1,n,cur);
                //backtrack
                unMark(n,row,i,column,diagonal,revDiagonal);
            }
        }
    }
    private boolean valid(int n,int row,int column,boolean [] columnUsed,boolean [] diagonal,boolean [] revDiagonal){
        return (columnUsed[column]==false)&&(diagonal[column+row]==false)&&(revDiagonal[-column+row+n-1]==false);
    }

    private void mark(int n,int row,int column,boolean [] columnUsed,boolean [] diagonal,boolean [] revDiagonal){
        columnUsed[column]=true;
        diagonal[column+row]=true;
        revDiagonal[-column+row+n-1]=true;
    }

    private void unMark(int n,int row,int column,boolean [] columnUsed,boolean [] diagonal,boolean [] revDiagonal){
        columnUsed[column]=false;
        diagonal[column+row]=false;
        revDiagonal[-column+row+n-1]=false;
    }

    private List<Integer> toList(int [] array){
        List<Integer> list=new ArrayList<>();
        for(int num:array){
            list.add(num);
        }
        return list;
    }

    public static void main(String [] args){
        NQueens nQueens=new NQueens();
        System.out.println(nQueens.nqueens(4)+"   "+nQueens.nqueensII(4));
    }
}
