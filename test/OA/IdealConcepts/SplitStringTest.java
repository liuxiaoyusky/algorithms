package OA.IdealConcepts;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SplitStringTest {

    @Test
    void split() {
        List<String> list = Arrays.asList("sdf", "sdfs","\" 1 \"");
        List<String> ans = SplitString.split("sdf sdfs \" 1 \"");
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), ans.get(i));
            System.out.println(list.get(i));
        }
    }
}