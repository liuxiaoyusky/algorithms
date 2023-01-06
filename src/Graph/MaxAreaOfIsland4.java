package Graph;

import java.util.*;

//https://leetcode.com/problems/max-area-of-island/
public class MaxAreaOfIsland4 {

    private final int [][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    class Point {
        int i;
        int j;
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Deque<Point> queue = new LinkedList<>();
        boolean [][] visited = new boolean [grid.length][grid[0].length];
        int max = 0;
        int cur = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if (visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                if(grid[i][j] == 0) {
                    continue;
                }

                cur = 1;
                queue.offerLast(new Point(i, j));
                //find the size of island
                while (!queue.isEmpty()) {
                    Point curPoint = queue.pollFirst();
                    for (int [] dir : DIRS) {
                        int curI = curPoint.i + dir[0];
                        int curJ = curPoint.j + dir[1];
                        if (curI < 0 || curI >= grid.length || curJ < 0 || curJ >= grid[0].length) {
                            continue;
                        }
                        if (visited[curI][curJ]){
                            continue;
                        }
                        visited[curI][curJ] = true;
                        if (grid[curI][curJ] == 1) {
                            cur++;
                            queue.offerLast(new Point(curI, curJ));
                        }
                    }
                }
                max = Math.max(max, cur);
                cur = 0;
            }
        }
        return max;
    }
}
