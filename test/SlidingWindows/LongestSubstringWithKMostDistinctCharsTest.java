package SlidingWindows;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithKMostDistinctCharsTest {


    LongestSubstringWithKMostDistinctChars l = new LongestSubstringWithKMostDistinctChars();
    String a = "eceba";
    String b = "aa";
    String c = "aabbbbccccddddddddddffffccc";
    @Test
    void longest() {
        assertEquals(3,l.longest(a,2));
        assertEquals(3,l.longestII(a,2));

        assertEquals(2,l.longest(b,1));
        assertEquals(2,l.longestII(b,1));


        assertEquals(l.longest(c,3),l.longestII(c,3));

    }

    @Test
    void longestII() {
    }
}