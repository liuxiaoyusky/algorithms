package GraphSearchAlgorithmIII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleIITest {

    @Test
    void findOrder() {
        CourseScheduleII s = new CourseScheduleII();
        assertArrayEquals(new int []{0,1},s.findOrder(2, new int [][]{{1,0}}));
        assertArrayEquals(new int [0],s.findOrder(4, new int
                [][]{{1,0},{2,0},{3,1},{3,2},{2,3}}));
    }
}