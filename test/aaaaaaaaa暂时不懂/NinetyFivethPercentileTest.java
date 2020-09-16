package aaaaaaaaa暂时不懂;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NinetyFivethPercentileTest {

    @BeforeAll
    static void beforeAll() {
        List<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        System.out.println("start");
    }

    @Test
    void percentile95() {
        System.out.println("test");

    }
}