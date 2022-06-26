package 刷题.递归;

import java.util.LinkedList;
import java.util.List;
/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens
attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer
 in any order.
Each solution contains a distinct board configuration of the n-queens' placement,
 where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]

Constraints:
    1 <= n <= 9

 */
public class NQueens51 {
    //use four int arrays to represent the location of queens order: rows, columns, lefttop, leftbottom
    //place a queen such that there doesn't exist another queen on same row/column/diagonals
    public List<List<String>> solveNQueens(int n) {
        int [] rows = new int[n];
        int [] cols = new int[n];
        /*
        0 1 2 3                 4 3 2 1
        1                       5
        2               =>      6
        3                       7

        [0,0],[1,1],[2,2] => 4;
        [1,0],[2,1] => 5;
        [0,3] => 1
        [3,0] => 7
        [i,j] => i - j + 4
         */
        int [] leftTop = new int[2 * n];
        /*
        0                       1
        1                       2
        2               =>      3
        3 1 2 3                 4 5 6 7

        [0,0],[1,1],[2,2] => 4;
        [1,0],[2,1] => 5;
        [0,3] => 3
        [3,0] => 7
        [i,j] => i + j + 1
         */

        int [] leftBottom = new int[2 * n];
        List<List<String>> ans = new LinkedList<>();
        helper(rows, cols,leftTop, leftBottom, n, ans);
        return ans;
    }

    private void helper(int [] rows, int [] cols, int [] leftTop, int [] leftBottom,
                        int queenLeft, List<List<String>> ans) {
        //base case
        if (queenLeft == 0) {
            ans.add(arrayToString(rows));
            return;
        }

        //general case: try place a queen on row[queenLeft - 1], for every possible cols
        //before place, check cols, diagonals, if possible, place and go next row
        for (int i = 0; i < cols.length; i++) {
            if (cols[i] == 0 && leftTop[queenLeft - 1 + i + 1] == 0
                    && leftBottom[queenLeft - 1 - i + cols.length] == 0) {
                rows[queenLeft - 1] = i;
                cols[i] = queenLeft - 1;
                leftTop[queenLeft - 1 + i + 1] = queenLeft - 1;
                leftBottom[queenLeft - 1 - i + cols.length] = queenLeft - 1;
                helper(rows, cols, leftTop, leftBottom, queenLeft - 1, ans);

                //back track
                rows[queenLeft - 1] = 0;
                cols[i] = 0;
                leftTop[queenLeft - 1 + i + 1] = 0;
                leftBottom[queenLeft - 1 - i + cols.length] = 0;
            }
        }
    }

    private List<String> arrayToString(int [] rows) {
        List<String> cur= new LinkedList<>();
        StringBuilder stringBuilder  = null;
        for (int num: rows) {
            stringBuilder = new StringBuilder();
            for (int i = 0; i < rows.length; i++) {
                if (i == num) {
                    stringBuilder.append('Q');
                } else {
                    stringBuilder.append('.');
                }
            }
            cur.add(stringBuilder.toString());
        }
        return cur;
    }
}
