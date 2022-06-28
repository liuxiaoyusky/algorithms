package 刷题.递归;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all of the following rules:
    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Example 1:
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],
["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],
["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],
["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],
["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:



Constraints:
    board.length == 9
    board[i].length == 9
    board[i][j] is a digit or '.'.
    It is guaranteed that the input board has only one solution.

 */
public class SudokuSolver37 {
    //1.scan the board first to make indicators with array of sets that indicates elements in a row/column/block
    //2. use board to keep track of answers, when one answer apppears,finish and return
    //go by rows, try fit elements in current column

    //base case:the board is full, convert back and return
    public void solveSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int [][] curBoard = new int[m][n];
        boolean [][] rows = new boolean[m][n];
        boolean [][] cols = new boolean[m][n];
        boolean [][] blocks = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = board[i][j] - '0';
                if (cur < 10 && cur > 0) {
                    curBoard[i][j] = cur;
                    rows[i][cur - 1] = true;
                    cols[j][cur - 1] = true;

                    int blockIndex = i / 3 * 3 + j / 3;
                    blocks[blockIndex][cur - 1] = true;
                    count++;
                }
            }
        }

        boolean [] found = new boolean[1];
        helper(board, 0 , 0, curBoard, rows, cols, blocks, count, found);
        return;
    }

    private void helper(char [][] board, int row, int col, int [][] curBoard, boolean [][] rows,
                        boolean [][] cols, boolean [][] blocks, int count, boolean [] found) {
        //base case
        if (found[0]) {
            return;
        }

        if (count == board.length * board[0].length) {
            found[0] = true;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j] = (char)(curBoard[i][j] + '0');
                }
            }
            return;
        }


        //general case, try all nine numbers in board[row][col] if current index is '.'
        int nextCol = (col + 1) % board[0].length;
        int nextRow = row + (col + 1) / board[0].length;
        if ((board[row][col]  != '.')) {
            helper(board,nextRow,nextCol,curBoard,rows,cols,blocks,count, found);
        } else {
            for(int i = 1; i <= 9 && !found[0]; i++) {
                int blockIndex = row / 3 * 3 + col / 3;
                if (!rows[row][i - 1] && !cols[col][i - 1] && !blocks[blockIndex][i - 1]) {
                    curBoard[row][col] = i;
                    rows[row][i - 1] = true;
                    cols[col][i - 1] = true;
                    blocks[blockIndex][i - 1] = true;
                    helper(board, nextRow, nextCol, curBoard, rows, cols, blocks, count + 1, found);

                    //backtrack
                    curBoard[row][col] = 0;
                    rows[row][i - 1] = false;
                    cols[col][i - 1] = false;
                    blocks[blockIndex][i - 1] = false;
                }
            }
        }
    }
}
