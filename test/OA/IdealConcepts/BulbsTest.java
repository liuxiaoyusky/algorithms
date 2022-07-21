package OA.IdealConcepts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BulbsTest {

    @Test
    void changeBulbs() {
        assertEquals("XOOXX",Bulbs.changeBulbs(2,"XXOXX"));
        assertEquals("XXXOX",Bulbs.changeBulbs(2,"XOOXX"));
    }
}