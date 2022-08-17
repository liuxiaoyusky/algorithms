package DFSII;
/*
Randomly generate a maze of size N * N (where N = 2K + 1) whose corridor and wall’s width are both 1 cell. For each pair of cells on the corridor, there must exist one and only one path between them. (Randomly means that the solution is generated randomly, and whenever the program is executed, the solution can be different.). The wall is denoted by 1 in the matrix and corridor is denoted by 0.

Assumptions

    N = 2K + 1 and K >= 0
    the top left corner must be corridor
    there should be as many corridor cells as possible
    for each pair of cells on the corridor, there must exist one and only one path between them

Examples

N = 5, one possible maze generated is

        0  0  0  1  0

        1  1  0  1  0

        0  1  0  0  0

        0  1  1  1  0

        0  0  0  0  0
 */
public class GenerateRandomMaze {
    //assume n = 2 * k + 1, where k >= 0
    //start with all 1, make path in walls
    //for all even ij,they must be 0
    //we need to choose in which order to connect these even ij, and mark
    //all passed cell as 0
    public int [][] maze(int n) {
        int [][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = 1;
            }
        }

        maze[0][0] = 0;
        helper(maze, 0, 0);
        return maze;
    }

    enum Dir {
        NORTH(-1, 0),SORTH(1, 0), WEST(0, -1), EAST(0, 1);

        int x;
        int y;

        Dir (int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int moveX(int cur, int steps) {
            return cur + x * steps;
        }

        public int moveY(int cur, int steps) {
            return cur + y * steps;
        }
    }
    //move 2 steps at once

    private void helper(int [][] maze, int i, int j) {
        //visit 4 directions one by one, make the order randomly
        Dir [] dirs = Dir.values();
        shuffle(dirs);
        for (Dir dir : dirs) {
            int nextX = dir.moveX(i,2);
            int nextY = dir.moveY(j,2);
            if (isValidWall(maze, nextX, nextY)) {
                //mark target cell as 0
                maze[nextX][nextY] = 0;
                //mark path cell as 0
                maze[dir.moveX(i,1)][dir.moveY(j,1)] = 0;

                //DFS
                helper(maze,nextX, nextY);
            }
        }
    }

    private boolean isValidWall(int [][] maze, int x, int y) {
        if (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1) {
            return true;
        }
        return false;
    }

    private void shuffle(Dir [] dirs) {
        for (int i = 0; i < dirs.length; i++) {
            int next = (int) (Math.random()*(dirs.length - i));
            Dir cur = dirs[i];
            dirs[i] = dirs[next];
            dirs[next] = cur;
        }
    }
}
