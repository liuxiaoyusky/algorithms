package 刷题.递归;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolver37Test {

    @Test
    void solveSudoku() {
        SudokuSolver37 solver = new SudokuSolver37();
        char [][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = '.';
            }
        }
        solver.solveSudoku(board);
    }
}