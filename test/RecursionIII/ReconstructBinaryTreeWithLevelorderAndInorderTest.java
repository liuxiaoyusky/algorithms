package RecursionIII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReconstructBinaryTreeWithLevelorderAndInorderTest {

    @Test
    void reconstruct() {
        int [] ints = new int[]  {5, 3, 8, 1, 4, 11};
        int [] level = new int[] {1, 3, 4, 5, 8, 11};
        ReconstructBinaryTreeWithLevelorderAndInorder r = new ReconstructBinaryTreeWithLevelorderAndInorder();
        r.reconstruct(ints, level);
    }
}