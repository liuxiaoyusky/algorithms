package Graph;
//https://app.laicode.io/app/problem/525
public class NumOfIslands3 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        boolean [][] visited = new boolean [grid.length] [grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    findIsland(grid, i, j, visited);
                    count++;
                }

            }
        }
        return count;
    }

    private final int [][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void findIsland(char [][] grid, int i, int j, boolean [][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        if (grid[i][j] == '0') {
            return;
        }

        else {
            for (int [] dir : DIRS) {
                findIsland(grid, i + dir[0], j + dir[1], visited);
            }
        }
    }
}
