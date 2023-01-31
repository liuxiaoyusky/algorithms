package Graph;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/jump-game-ii/
//time: O(n^2) Space:O(n)
public class JumpGame8 {
    public int jumpGame(int [] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean [] visited = new boolean[array.length];
        visited[0] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                int rightMost = index + array[index];
                if (rightMost >= array.length - 1) {
                    return step;
                }
                for (int j = rightMost; j > index; j--) {
                    if (visited[j] == false) {
                        queue.offer(j);
                        visited[ j] = true;
                    }
                }
            }
        }
        return -1;
    }
}
