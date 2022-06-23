package OA.Mathworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestSubsequenceTest {

    @BeforeAll
    public static void init(){

    }




    @Test
    void smallestSubsequence() {
        String input = new String("bcabc");
        String input2 = new String("cbacdcbc");
        SmallestSubsequence ss = new SmallestSubsequence();
        String result = ss.smallestSubsequence(input);
        assertEquals(true, "abc".equals(result));
    }

    @Test
    void smallestSubsequence2() {
        String input = new String("bcabc");
        String input2 = new String("cbacdcbc");
        SmallestSubsequence ss = new SmallestSubsequence();
        String result = ss.smallestSubsequence(input2);
        assertEquals(true, "acdb".equals(result));
    }
}