package CrossTrainingI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetCountArrayTest {

    @Test
    void countArray() {
        assertArrayEquals(new int[]{3,0,1,0}, GetCountArray.countArray(new int[] {4,1,3,2}));
    }
}