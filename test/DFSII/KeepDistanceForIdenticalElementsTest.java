package DFSII;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeepDistanceForIdenticalElementsTest {
    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[] {2,3,1,2,1,3},KeepDistanceForIdenticalElements.keepDistance(3));
    }
}