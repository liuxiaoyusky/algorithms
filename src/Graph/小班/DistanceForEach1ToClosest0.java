package Graph.小班;

import java.util.LinkedList;
import java.util.Queue;

//given a 0 1 matrix, calculate the distance from each 1 to the closest 0.
/*
vertex: 1
edge: 4 directions inbound 0 or 1

all to any problem
solution 1:
for each 1, find the nearest 0 (k of 1 to any)
for each 0, find all 1's distance and update it with the shortest one

no obsticals!
starting from all 0's, mark the nearest 1 and push them into the queue, check their neighbor 1
 that are unvisited

each only visit once: O(V)

 */
public class DistanceForEach1ToClosest0 {
    class Point{
        int i;
        int j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            //same reference
            if (o == this) {
                return true;
            }

            //check type
            if (!(o instanceof Point)){
                return false;
            }

            Point oP = (Point) o;
            return oP.i == i && oP.j == j;
        }

        @Override
        public int hashCode() {
            return i*31 + j;
        }
    }

    public int [][] findMinDis(int [][] matrix) {
        //sanity check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] steps = new int[m][n];

        //find all 0's
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new Point(i,j));
                }
            }
        }

        int curStep = 0;

        //find all min steps
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                 Point cur = queue.poll();

                 //check all four directions
                for (int [] dir : DIRS) {
                    int newI = cur.i + dir[0];
                    int newJ = cur.j + dir[1];

                    //out of bound
                    if (!inBound(newI, newJ, m, n)) {
                        continue;
                    }

                    //visited
                    if (steps[newI][newJ] != 0) {
                        continue;
                    }

                    //not 1
                    if (matrix[newI][newJ] != 1) {
                        continue;
                    }


                    //offer into queue and mark visited
                    steps[newI][newJ] = curStep + 1;
                    queue.offer(new Point(newI, newJ));
                }
            }
        }

        return steps;
    }

    private boolean inBound(int i, int j, int m, int n) {
        return i >=0 && i < m && j >=0 && j < n;
    }

    private static int [][] DIRS = {{-1, 0}, {1,0}, {0, 1}, {0, -1}};
}
