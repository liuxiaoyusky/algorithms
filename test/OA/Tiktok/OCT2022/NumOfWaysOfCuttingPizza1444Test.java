package OA.Tiktok.OCT2022;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumOfWaysOfCuttingPizza1444Test {

    @Test
    void ways() {
        NumOfWaysOfCuttingPizza1444 n = new NumOfWaysOfCuttingPizza1444();
        assertEquals(3,n.ways(new String[] {"A..","AAA","..."}, 3));
    }
}