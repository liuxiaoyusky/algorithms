package OA.uworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringRemoveDupAndReturnMaxTest {

    @Test
    void doit() {
        StringRemoveDupAndReturnMax s = new StringRemoveDupAndReturnMax();
        //assertEquals("s", s.doit("s"));
        //assertEquals("sd", s.doit("sdd"));
        assertEquals("cba", s.doit("abccba"));
        assertEquals("dcba", s.doit("abcadcba"));
    }
}