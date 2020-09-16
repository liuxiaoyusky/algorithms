package SortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    Random random = new Random();
    public int[] quickSort(int[] array) {
        //corner case
        if (array == null || array.length == 0) {
            return array;
        }

        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort (int [] array, int start, int end) {
        //base case
        if (start >= end) {
            //only one or zero element left
            return;
        }

        //locate the place of one element
        int index = start + random.nextInt(end - start + 1);
        int cur = array[index];
        swap(array, index, end);
        int i = start;//[start,i) smaller than cur
        int j = end - 1;//(j,end] larger than or equal to cur
        while (i <= j) {
            if (array[i] < cur) {
                i++;
            } else if (array[j] >= cur) {
                j--;
            } else {
                swap(array, i, j);
            }
        }
        //we first put our pivot to the rightmost, now i is point to a larger number. swap back these two
        swap(array,i,end);

        //subproblem
        quickSort(array,start, i - 1);
        quickSort(array,i + 1, end);
    }

    private void swap(int [] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String [] args) {
        QuickSort quickSort = new QuickSort();
        int [] array = new int[3];
        array[1] = 3;
        array[0] = 2;
        array[2] = 4;
        int [] array2 = new int[] {3,2,4,1};
        quickSort.quickSort(array);
        quickSort.quickSort(array2);
        System.out.println(""+array[0]+array[1]+array[2]);
        System.out.println(Arrays.toString(array2));
    }
}
