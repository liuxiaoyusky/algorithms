package GraphSearchAlgorithmIII;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {

    @Test
    void ladderLength() {
        WordLadder w = new WordLadder();
        int c = w.ladderLength("d", "a", Arrays.asList("a","b", "d"));
        assertEquals(2,c);
    }
}