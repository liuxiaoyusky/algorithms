package DynamicProgrammingIV;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanIWinIITest {

    @Test
    void canWin() {
        CanIWinII c = new CanIWinII();
        assertEquals(513, c.canWin(new int [] {52,42,62,79,6,11,2,7,19,99,23,48,97,2,85,71,91}));
        assertEquals(455, c.canWin(new int [] {50,61,7,98,76,5,6,22,2,82,21,58,45,95,89,48,68}));
        assertEquals(366, c.canWin(new int [] {18,74,89,72,90,84,63,8,2,20,99,88,5}));
    }
}