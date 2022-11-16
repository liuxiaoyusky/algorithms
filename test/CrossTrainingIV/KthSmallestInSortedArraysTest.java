package CrossTrainingIV;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestInSortedArraysTest {

    @Test
    void kth() {
        KthSmallestInSortedArrays k = new KthSmallestInSortedArrays();
        assertEquals(1,k.kth(new int [] {1},new int [] {2,3,4,5,6},1));
        assertEquals(12,k.kth(new int [] {1,4,5,5,8,12,12,12},new int [] {2,2,3,7,9,9,9},14));
        assertEquals(2,k.kth(new int [] {1,4,5,5,8,12,12,12},new int [] {2,2,3,7,9,9,9},3));
    }
}