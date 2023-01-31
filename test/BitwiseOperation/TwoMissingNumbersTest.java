package BitwiseOperation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoMissingNumbersTest {

    @Test
    void missingNumbers() {
        assertArrayEquals(new int[] {2,4}, TwoMissingNumbers.missingNumbers(new int []{0,1,3,5,6}));
    }
}