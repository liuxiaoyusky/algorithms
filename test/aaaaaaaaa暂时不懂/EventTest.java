package aaaaaaaaa暂时不懂;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    Event e = new Event();
    int [] a = new int [] {4, 4, 1, 0, 0, 0, 7, 7, 7};
    int [] b = new int [] {4, 4};
    int [] c = new int [] {};
    @Test
    void findMostKFrequency() {
        List<Integer> result = e.findMostKFrequency(a, 2);
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(7);
        assertEquals(ans,result);
    }
}