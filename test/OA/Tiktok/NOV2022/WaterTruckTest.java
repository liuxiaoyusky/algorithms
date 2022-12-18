package OA.Tiktok.NOV2022;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterTruckTest {

    @Test
    void water() {
        WaterTruck w = new WaterTruck();
        assertEquals(1, w.water(new int [][] {{0,3},{3,5}}, 7));
    }
}