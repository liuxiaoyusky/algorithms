package CrossTrainingI;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDedupITest {
    @BeforeEach
    void setUp() {
        int [] input = new int [] {1,1,2,3,3,4};
        int [] output = new int []{1,2,3,4};
    }

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void dedup() {
    }
}