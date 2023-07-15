package 刷题;

public class NQueensII {
    public int totalNQueens(int n) {
        int [] counts = new int [1];
        boolean [] cols = new boolean [n];
        boolean [] leftTop = new boolean [2*n];
        boolean [] leftBottom = new boolean [2*n];

        helper(n, cols, leftTop, leftBottom, counts);
        return counts[0];
    }

    private void helper(int queenLeft, boolean [] cols,
                        boolean [] leftTop, boolean [] leftBottom, int [] counts) {
        //corner case
        if (queenLeft == 0) {
            counts[0]++;
            return;
        }

        int n = cols.length;
        int row = n - queenLeft;
        //try place queen at (n - queenLeft) row
        for (int i = 0; i < n; i++) {
            //skip board, not neccessary, skip board, not neccessary
            //try place on cols, diagonals

            if (!cols[i]
                    && !leftTop[n - i + row] &&
                    !leftBottom[2 * n - row - i - 1]) {
                cols[i] = true;
                leftTop[n - i + row] = true;
                leftBottom[2 * n - row - i - 1] = true;
                helper(queenLeft - 1, cols, leftTop, leftBottom, counts);

                //backtrack
                cols[i] = false;
                leftTop[n - i + row] = false;
                leftBottom[2 * n - row - i - 1] = false;
            }
        }

    }
}