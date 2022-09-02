package GraphSearchAlgorithmIII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthClosestPointToOriginalPointTest {

    @Test
    void closest() {
        int [] a = new int[] {1,2,3};
        int [] b = {2,4};
        int [] c = {1,2};
        KthClosestPointToOriginalPoint k = new KthClosestPointToOriginalPoint();
        k.closest(a,b,c,2);
    }
}