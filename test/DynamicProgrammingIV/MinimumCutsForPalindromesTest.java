package DynamicProgrammingIV;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCutsForPalindromesTest {

    @Test
    void minCuts() {
        MinimumCutsForPalindromes m = new MinimumCutsForPalindromes();
        assertEquals(1,m.minCuts("aaaaaabbabb"));
        assertEquals(2,m.minCuts("abcbd"));
    }
}