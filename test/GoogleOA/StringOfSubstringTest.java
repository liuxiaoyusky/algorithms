package GoogleOA;

import OA.google.StringOfSubstring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringOfSubstringTest {

    @Test
    void CornerCase() {
        assertEquals(0, StringOfSubstring.findNumOfStringOfSubstring("abcd",""));
    }

    @Test
    void normalCase() {
        assertEquals(3,StringOfSubstring.findNumOfStringOfSubstring("abcd","cdabcdab"));
    }

    @Test
    void normalCaseII() {
        assertEquals(2,StringOfSubstring.findNumOfStringOfSubstring("ababc","abcab"));
    }

    @Test
    void notMatch() {
        assertEquals(-1,StringOfSubstring.findNumOfStringOfSubstring("abcdb","cdabcdab"));
    }

    @Test
    void notMatchII() {
        assertEquals(-1,StringOfSubstring.findNumOfStringOfSubstring("abcd","cdabcab"));
    }
}