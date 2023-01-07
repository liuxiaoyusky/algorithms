package Graph;
//https://leetcode.com/problems/word-search/
public class WordSearch6 {
    static private final int [][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean wordSearch(char [][] board, String target) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean [][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, 0, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char [][] board, int i, int j,int index, String target, boolean [][] visited) {
        //base case: finish searching
        if (index == target.length()) {
            return true;
        }


        //out of bound
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        //visited before
        if (visited[i][j]) {
            return false;
        }

        if (target.charAt(index) == board[i][j]) {
            visited[i][j] = true;
            for (int [] dir : DIRS) {
                if (exist(board, i + dir[0], j + dir[1], index + 1, target, visited)) {
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
}
