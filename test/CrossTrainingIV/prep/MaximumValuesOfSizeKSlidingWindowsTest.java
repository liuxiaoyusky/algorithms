package CrossTrainingIV.prep;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaximumValuesOfSizeKSlidingWindowsTest {

    @Test
    void maxWindows() {
        MaximumValuesOfSizeKSlidingWindows m = new MaximumValuesOfSizeKSlidingWindows();
        assertEquals(new ArrayList<Integer>(Arrays.asList(new Integer []{2, 3, 4, 5, 6, 7, 8, 9, 9, 1})),
                m.maxWindows(new int [] {1,2,3,4,5,6,7,8,9,1,1}, 2));
        assertEquals(new ArrayList<Integer>(Arrays.asList(new Integer []{3, 3, 4, 4, 4})),
                m.maxWindows(new int [] {1, 2, 3, 2, 4, 2, 1}, 3));
    }
}