package CrossTrainingIII;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Merge K sorted array into one big sorted array in ascending order.
Assumptions
    The input arrayOfArrays is not null, none of the arrays is null either.
 */
public class MergeKsortedArrays {
    //keep track of the first element in each array, find the smallest one and add it to the
    //result array, a minheap can help find the smallest


    public int[] merge(int[][] arrayOfArrays) {
        int rows = arrayOfArrays.length;
        PriorityQueue<Entry> pq = new PriorityQueue<>(rows, new MyComparator());
        int length = 0;
        int curRow = 0;
        for (int [] array : arrayOfArrays) {
            length += array.length;
            if (array.length != 0) {
                pq.offer(new Entry(curRow, 0, array[0]));
            }
            curRow++;
        }

        int [] result = new int [length];
        for (int i = 0; i < length; i++) {
            Entry curEntry = pq.poll();
            result[i] = curEntry.value;

            //replace with next element in this array if exists
            int curRoww = curEntry.row;
            int curCol = curEntry.column + 1;
            int [] curArray = arrayOfArrays[curRoww];
            if (curCol < curArray.length) {
                int newValue = curArray[curCol];
                curEntry.value = newValue;
                curEntry.column = curCol;
                pq.offer(curEntry);
            }
        }

        return result;
    }

    static class Entry {
        int row;
        int column;
        int value;

        public Entry(int x, int y, int z) {
            this.row = x;
            this.column = y;
            this.value = z;
        }
    }

    static class MyComparator implements Comparator<Entry> {
        @Override
        public int compare (Entry o1, Entry o2) {
            if (o1.value == o2.value) {
                return 0;
            } else {
                return o1.value < o2.value ? -1 : 1;//not return o1 - o2 in case of overflow
            }
        }
    }
}
