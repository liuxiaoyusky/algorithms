package CrossTrainingIV;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInShiftedSortedArrayITest {
    @Test
    void findShiftNormalCase() {
        assertEquals(2,
                SearchInShiftedSortedArrayI.findRightShiftNumber(new int[] {3,4,5,1,2}));
    }

    @Test
    void findShift0() {
        assertEquals(0,
                SearchInShiftedSortedArrayI.findRightShiftNumber(new int[] {3,4,5}));
    }

    @Test
    void findShiftNull() {
        assertEquals(0,
                SearchInShiftedSortedArrayI.findRightShiftNumber(new int[] {}));
    }

    @Test
    void findShiftNormalCase2() {
        assertEquals(1,
                SearchInShiftedSortedArrayI.findRightShiftNumber(new int[] {4,3}));
    }

    @Test
    void findShiftNormalCase3() {
        assertEquals(1,
                SearchInShiftedSortedArrayI.findRightShiftNumber(new int[] {5,1,3}));
    }

    @Test
    void calculateIndex() {
        assertEquals(0,
                SearchInShiftedSortedArrayI.calculateIndex(1,2,3));
    }

    @Test
    void findTarget() {
        assertEquals(0,
                SearchInShiftedSortedArrayI.search(new int[] {5,1,3}, 5));
    }
}