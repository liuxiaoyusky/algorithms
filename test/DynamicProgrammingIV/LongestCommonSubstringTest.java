package DynamicProgrammingIV;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubstringTest {

    @Test
    void longestCommon() {
        LongestCommonSubstring l = new LongestCommonSubstring();
        assertEquals("", l.longestCommon("ab", ""));
    }
}