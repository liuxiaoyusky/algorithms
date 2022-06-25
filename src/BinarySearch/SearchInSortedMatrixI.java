package BinarySearch;
/*
Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. The first element of next row is larger than (or equal to) the last element of previous row.

Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.

Assumptions:

    The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.

Examples:

matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }

target = 7, return {1, 2}

target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
 */
public class SearchInSortedMatrixI {
    //given ascending matrix not null, return a int [];
    public int[] search(int[][] matrix, int target) {
        int [] failure = new int [] {-1, -1};
        int row = matrix.length;
        int col = matrix[0].length;

        //define seraching space regard it as an array
        int left = 0;
        int right = row * col - 1;

        //search until no element in searching space
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int [] index = findIndex(mid, col);
            if (matrix[index[0]][index[1]] == target) {
                return index;
            } else if (matrix[index[0]][index[1]] < target) {
                //target in right half
                left = mid + 1;
            } else {
                //target in left half
                right = mid - 1;
            }
        }

        return failure;
    }

    private int [] findIndex(int val, int cols) {
        int [] index = new int [2];
        index[0] = val / cols;
        index[1] = val % cols;
        return index;
    }
}
