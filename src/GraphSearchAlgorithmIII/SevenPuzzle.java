package GraphSearchAlgorithmIII;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class SevenPuzzle {
    //there are totally 8! combination
    //do it inversely, start from 01234567 and find the smallest steps to make it the start values(bfs) -> could run very long time
    //for 0 : switch up: i and i + 4, switch down: i and i - 4, switch left: i and i - 1, switch right: i and i + 1
    //which means for each non 0 letter, it can only switch with left, down, top and right. if they are too far away from there place, return -1
    public int numOfSteps(int[] values) {
        //init
        int [] directions = new int [] {-1, 1, -4, 4};
        Map<Integer,Integer> map = new HashMap<>();
        Queue<int []> boards = new ArrayDeque<>();
        int [] start = new int [] {0,1,2,3,4,5,6,7};
        boards.offer(start);
        map.put(toValue(start),0);
        int target = toValue(values);

        while (!boards.isEmpty()) {
            //base case
            int [] cur = boards.poll();
            int curValue = toValue(cur);
            int steps = map.get(curValue);
            if (curValue == target) {
                return steps;
            } else {
                //recursion on current board status
                steps++;
                int index = findZero(cur);
                for (int i: directions) {
                    int next = index + i;
                    //check valid index
                    //corner case for index 3 and 4
                    if (next == 3 && index == 4) {
                        continue;
                    } else if (next == 4 && index == 3) {
                        continue;
                    }
                    else if (next >= 0 && next < 8) {
                        int [] nextBoard = cur.clone();
                        swap(nextBoard, index, next);
                        int nextValue = toValue(nextBoard);
                        if(!map.containsKey(nextValue)) {
                            boards.offer(nextBoard);
                            map.put(nextValue,steps);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private void swap(int [] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private int findZero(int [] values) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private int toValue(int [] values) {
        int value = 0;
        for (int i = 0; i < values.length; i++) {
            value = value * 10 + values[i];
        }
        return value;
    }
}
