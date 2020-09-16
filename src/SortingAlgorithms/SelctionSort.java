package SortingAlgorithms;
/*
Given an array of integers, sort the elements in the array in ascending order. The selection sort algorithm should be used to solve this problem.

Examples

    {1} is sorted to {1}
    {1, 2, 3} is sorted to {1, 2, 3}
    {3, 2, 1} is sorted to {1, 2, 3}
    {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

Corner Cases

    What if the given array is null? In this case, we do not need to do anything.
    What if the given array is of length zero? In this case, we do not need to do anything.


 */
public class SelctionSort {
    //assume n elements in array. time: O(n^2) space: O(1)
    public int[] solve(int[] array) {
        //corner case
        if (array == null || array.length == 0) {
            return array;
        }

        //for each space, find the ith smallest element and swap to it
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }

        return array;
    }

    private void swap (int [] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

