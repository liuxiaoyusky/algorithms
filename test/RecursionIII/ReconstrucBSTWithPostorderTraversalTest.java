package RecursionIII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReconstrucBSTWithPostorderTraversalTest {

    @Test
    void reconstruct() {
        ReconstrucBSTWithPostorderTraversal r = new ReconstrucBSTWithPostorderTraversal();
        r.reconstruct(new int[] {1,2,4,7,5,10,13,12,8,3});
    }
}