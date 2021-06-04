package DFSII;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSubsetsWithMinDifferenceTest {
    @BeforeEach
    void setUp() {
        int [] input = new int [] {1,1,2,3,3,4};
        int [] output = new int []{1,2,3,4};
    }

//    @BeforeAll
//    static void beforeAll() {
//
//    }
    @Test
    void minDifference() {
//        assertEquals('1',0,0);
        System.out.println("start test");
        assertEquals(4, new TwoSubsetsWithMinDifference().minDifference(new int []{1,2,3,4}));
    }
}