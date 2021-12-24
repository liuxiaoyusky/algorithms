package OA.Tiktok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class frogJumpTest {
    @Test
    void checkGeneralCase(){
        assertEquals(true, new frogJump().frogJump(new int[]{0,1,3,5,6,8,12,17}));
    }

}