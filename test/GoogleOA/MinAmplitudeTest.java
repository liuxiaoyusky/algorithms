package GoogleOA;

import OA.google.MinAmplitude;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinAmplitudeTest {

    @Test
    void checkMinHeap(){
        assertEquals(1, MinAmplitude.minAmplitude(new int[] {1,2,3,4,77}));
    }
}