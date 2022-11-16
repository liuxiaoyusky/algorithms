package 刷题;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakIITest {

    @Test
    void wordBreak() {
        WordBreakII w = new WordBreakII();
        assertEquals(Arrays.asList(new String[]{"cats and dog","cat sand dog"}),w.wordBreak("catsanddog", Arrays.asList(new String [] {"cat","cats","and","sand","dog"})));
    }
}