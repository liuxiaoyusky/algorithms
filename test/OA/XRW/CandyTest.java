package OA.XRW;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandyTest {

    @Test
    void candy() {
        Candy c = new Candy();
        c.candy(new int [] {29,51,87,87,72,12});
    }
}