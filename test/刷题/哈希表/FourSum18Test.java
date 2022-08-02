package 刷题.哈希表;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FourSum18Test {

    @Test
    void test1() {
        List<Integer> ans = List.of(2,2,2,2);
        List<Integer> result = new FourSum18().fourSum(new int[] {-2,-1,-1,1,1,2,2}, 0).get(0);
        for(int i = 0; i < ans.size(); i++) {
            Assertions.assertEquals(ans.get(i), result.get(i));
        }
    }
}