package CrossTrainingI;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindKClosestElementsTest {

    @Test
    void kClosestNumbers() {
        FindKClosestElements k = new FindKClosestElements();
        Assert.assertArrayEquals(new int [] {2,1,3}, k.kClosestNumbers(new int []{1,2,3}, 2,3));
    }
}