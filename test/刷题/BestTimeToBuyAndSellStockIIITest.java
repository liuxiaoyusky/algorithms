package 刷题;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockIIITest {

    @Test
    void maxProfit() {
        BestTimeToBuyAndSellStockIII b = new BestTimeToBuyAndSellStockIII();
        assertEquals(19, b.maxProfit(new int [] {14,9,10,12,4,8,1,16}));
        assertEquals(6, b.maxProfit(new int [] {3,3,5,0,0,3,1,4}));
    }
}