package OA.Tiktok.NOV2022;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrefixScoresTest {

    @Test
    void getPrefixScores() {
        PrefixScores.getPrefixScores(List.of(new Integer [] {1,2,1}));
    }
}