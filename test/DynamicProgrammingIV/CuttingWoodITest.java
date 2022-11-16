package DynamicProgrammingIV;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuttingWoodITest {

    @Test
    void minCost() {
        CuttingWoodI c = new CuttingWoodI();
        assertEquals(20, c.minCost(new int [] {2,4,7}, 10));
    }
}