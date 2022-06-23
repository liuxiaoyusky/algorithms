package CrossTrainingII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetCountArrayTest {

    @Test
    void countArray() {
        GetCountArray getCountArray = new GetCountArray();
        assertEquals(true, getCountArray.countArray(new int[] {1,2,3,4}).equals(new int [] {0,1,2,3}));
    }
}