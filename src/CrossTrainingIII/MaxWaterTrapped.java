package CrossTrainingIII;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/*
Given a non-negative integer 2D array representing the heights of bars in a matrix. Suppose each bar has length and width of 1. Find the largest amount of water that can be trapped in the matrix. The water can flow into a neighboring bar if the neighboring bar's height is smaller than the water's height. Each bar has 4 neighboring bars to the left, right, up and down side.

Assumptions

    The given matrix is not null and has size of M * N, where M > 0 and N > 0, all the values are non-negative integers in the matrix.

Examples

{ { 2, 3, 4, 2 },

  { 3, 1, 2, 3 },

  { 4, 3, 5, 4 } }

the amount of water can be trapped is 3,

at position (1, 1) there is 2 units of water trapped,

at position (1, 2) there is 1 unit of water trapped.
 */
public class MaxWaterTrapped {
    //start from boarders to inside, use minheap to find the lowerest column, cur
    //examinate the neighbor columns of cur, if visted, skip
    //if higher than cur, skip
    //if lower than cur, must able to trap water, height raise to cur's height,
    //difference of height trapped water

    class Column implements Comparable<Column> {
        int x;
        int y;
        int height;
        public Column(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        public int compareTo(Column o) {
            if (this.height == o.height) {
                return 0;
            }
            return this.height < o.height ? -1 : 1;
        }
    }

    private void addAllBoard(int [][] matrix, boolean [][] visited, PriorityQueue<Column> pq) {
        int row = matrix.length;
        int col = matrix[0].length;
        //top and bottom row
        for (int i = 0; i < col; i++) {
            pq.add(new Column(0,i, matrix[0][i]));
            visited[0][i] = true;
            pq.add(new Column(row - 1, i, matrix[row - 1][i]));
            visited[row - 1][i] = true;
        }

        //left and right column without first and last row
        for (int i = 1; i < row - 1; i++) {
            pq.add(new Column(i, 0, matrix[i][0]));
            visited[i][0] = true;
            pq.add(new Column(i, col - 1, matrix[i][col - 1]));
            visited[i][col - 1] = true;
        }
    }

    private List<Column> findNeighbor(Column cur, int [][] matrix) {
        int x = cur.x;
        int y = cur.y;
        int row = matrix.length;
        int col = matrix[0].length;
        List<Column> nei = new ArrayList<>(4);
        if (x - 1 >= 0) {
            nei.add(new Column(x - 1, y, matrix[x - 1][y]));
        }
        if (x + 1 < row) {
            nei.add(new Column(x + 1, y, matrix[x + 1][y]));
        }
        if (y - 1 >= 0) {
            nei.add(new Column(x, y - 1, matrix[x][y - 1]));
        }
        if (y + 1 < col) {
            nei.add(new Column(x, y + 1, matrix[x][y + 1]));
        }
        return nei;
    }

    public int maxTrapped(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        //corner case
        if (row < 3 || col < 3) {
            return 0;
        }

        boolean [][] visited = new boolean [row][col];
        PriorityQueue<Column> pq = new PriorityQueue<>(row + col);
        addAllBoard(matrix, visited, pq);

        int waterTrapped = 0;
        while (!pq.isEmpty()) {
            Column cur = pq.poll();
            List<Column> neighbor = findNeighbor(cur, matrix);
            for (Column nei : neighbor) {
                if (visited[nei.x][nei.y]){
                    continue;
                }
                waterTrapped += Math.max(cur.height - nei.height, 0);
                nei.height = Math.max(cur.height, nei.height);
                visited[nei.x][nei.y] = true;
                pq.offer(nei);
            }
        }

        return waterTrapped;
    }
}
