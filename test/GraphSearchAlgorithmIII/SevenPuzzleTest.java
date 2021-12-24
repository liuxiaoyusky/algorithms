package GraphSearchAlgorithmIII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SevenPuzzleTest {

    @Test
    void generalCase() {
        assertEquals(25,new SevenPuzzle().numOfSteps(new int[] {2,6,7,5,3,1,0,4}));
    }

    @Test
    void baseCase() {
        assertEquals(0,new SevenPuzzle().numOfSteps(new int[] {0,1,2,3,4,5,6,7}));
    }

    @Test
    void cornerCase() {
        assertEquals(-1,new SevenPuzzle().numOfSteps(new int[] {2,1,0,3,4,5,6,7}));
    }
}