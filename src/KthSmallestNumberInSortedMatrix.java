import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {
    /*
    Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements
     are also sorted in ascending order. Find the Kth smallest number in it.
     { {1,  3,   5,  7},
    {2,  4,   8,   9},
     {3,  5, 11, 15},
     {6,  8, 13, 18} }
    the 5th smallest number is 4
    the 8th smallest number is 6
     */

    public int kthSmallestNumberInSortedMatrix(int [][] matrix, int k){
        /*assmue:
           the matrix is not null, N > 0 and M > 0
           K > 0 and K <= N * M
         */
        int row = matrix.length;
        int column = matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k,new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2){
                if(c1.value == c2.value){
                    return 0;
                }
                return c1.value<c2.value? -1 : 1;
            }
        });

        boolean [][] visted = new boolean [row] [column];
        minHeap.offer(new Cell(0,0,matrix[0][0]));
        visted [0][0] = true;
        //poll k-1 times, the next one will be the kth smallest
        for(int i=0;i<k-1;i++){
            Cell cur = minHeap.poll();
            if(cur.column+1<column&&!visted[cur.row][cur.column+1]){
                minHeap.offer(new Cell(cur.row,cur.column+1,matrix[cur.row][cur.column+1]));
                visted[cur.row][cur.column+1] = true;
            }
            if(cur.row+1<row&&!visted[cur.row+1][cur.column]){
                minHeap.offer(new Cell(cur.row+1,cur.column,matrix[cur.row+1][cur.column]));
                visted[cur.row+1][cur.column] = true;
            }
        }

        Cell ans = minHeap.peek();
        return ans.value;
    }

    static class Cell{
        public int row;
        public int column;
        public int value;
        public Cell(int row, int column,int value){
            this.value = value;
            this.column = column;
            this.row = row;
        }
    }
}
