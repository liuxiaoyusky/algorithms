package DynamicProgramming;

import DynamicProgramming.LargestSquareSurroundedByOne;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestSquareSurroundedByOneTest {
    private static int [][] array;
    private static int [][] trap;
    @BeforeAll
    static void beforeAll() {
        trap = new int [][]{{1,1,1},{1,0,1},{1,1,1}};
        array = new int [][]{{1,1,1,1},{1,1,1,0},{1,1,1,1},{1,1,1,0}};
    }

    @Test
    void testFour() {
        int ans = new LargestSquareSurroundedByOne().largest(array);
        assertEquals(2,ans);
    }

    @Test
    void proveWrong(){
        int ans = new LargestSquareSurroundedByOne().largest(trap);
        assertEquals(1,ans);
    }
}