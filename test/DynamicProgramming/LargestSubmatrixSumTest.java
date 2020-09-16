package DynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestSubmatrixSumTest {

    @Test
    void test1() {
        int [][] matrix = new int [][] {{1}};
        int ans = new LargestSubmatrixSum().largest(matrix);
        assertEquals(1,ans);
    }

    @Test
    void testArray() {
        int [][] matrix = new int [][] {{1,2,3,-1,4}};
        int ans = new LargestSubmatrixSum().largest(matrix);
        assertEquals(9,ans);
    }

    @Test
    void testMatrix() {
        int [][] matrix = new int [][] {{2,-1,2,1,-3},{0,-2,-1,2,1},{3,2,1,-3,-2}};
        int ans = new LargestSubmatrixSum().largest(matrix);
        assertEquals(6,ans);
    }
}