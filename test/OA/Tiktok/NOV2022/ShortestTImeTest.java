package OA.Tiktok.NOV2022;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortestTImeTest {
    @Test
    void t(){
        String[][] input = new String[][]
                {{"home", "s1", "3"},
                        {"s1", "s2", "5"},
                        {"s1", "s3", "1"},
                        {"s3", "office", "1"},
                        {"s2", "office", "2"}
        };

        assertEquals(5,ShortestTIme.getShortest(input));
    }
}