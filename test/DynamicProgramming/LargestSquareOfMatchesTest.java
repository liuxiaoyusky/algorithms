package DynamicProgramming;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestSquareOfMatchesTest {
    private static int [][] hugeMatrix;
    @BeforeAll
    static void beforeAll() {
       hugeMatrix = new int[][] {{3,2,2,3},{1,0,1,0},{2,1,1,2},{0,3,3,1},{2,1,3,0},{1,3,0,3},{3,1,2,0}};
    }

    @Test
    void testRow() {
        int [][] matrix = new int[][] {{1,2}};
        assertEquals(0,new LargestSquareOfMatches().largestSquareOfMatches(matrix) );
    }

    @Test
    void test1() {
        int [][] matrix = new int[][] {{3,3},{3,3}};
        assertEquals(1,new LargestSquareOfMatches().largestSquareOfMatches(matrix));
    }

    @Test
    void testHugeMatrix() {
       int ans =  new LargestSquareOfMatches().largestSquareOfMatches(hugeMatrix);
       assertEquals(1,ans);
    }

    @Test
    void failedTest() {
        int [][]matrix = new int[][]{{3, 1, 1, 3, 0, 1, 1, 0}, {2, 0, 0, 2, 0, 0, 0, 0}, {3, 1, 3, 0, 0, 0, 0, 0}, {2, 0, 2, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 0, 0}};
        assertEquals(2,new LargestSquareOfMatches().largestSquareOfMatches(matrix));

    }
}