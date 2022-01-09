package CrossTrainingDIY;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeStonesTest {
    @Test
    void test1Element() {
        assertEquals(0, MergeStones.mergeStones(new int[] {0}));
    }

    @Test
    void test2Element() {
        assertEquals(2, MergeStones.mergeStones(new int[] {1,1}));
    }


    @Test
    void testGeneral() {
        assertEquals(20, MergeStones.mergeStones(new int[] {1,3,2,4}));
    }

    @Test
    void testGeneral2() {
        assertEquals(71, MergeStones.mergeStones(new int[] {2,1,1,3,5,7,10}));
    }

    @Test
    void testGeneral3() {
        assertEquals(28, MergeStones.mergeStones(new int[] {4,3,3,4}));
    }
}