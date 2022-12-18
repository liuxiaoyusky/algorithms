package CrossTrainingDIY;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHopperIVTest {

    @Test
    void minJump() {
        ArrayHopperIV a = new ArrayHopperIV();
        a.minJump(new int [] {1,2,0}, 0);
    }
}