package SortingAlgorithms;
/*
Given an array of balls, where the color of the balls can only be Red, Green or Blue, sort the balls such that all the Red balls are grouped on the left side, all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side. (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).

Examples

    {0} is sorted to {0}
    {1, 0} is sorted to {0, 1}
    {1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}

Assumptions

    The input array is not null.

Corner Cases

    What if the input array is of length zero? In this case, we should not do anything as well.
 */
public class RainbowSort {
    //left right pointers, [0,left) red, [left,right] Green, (right,length - 1] Blue
    //denote red = -1, green = 0, blue = 1
    public int[] rainbowSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }

        int left = 0;
        int right = array.length - 1;

        //go from left to right
        int pointer = 0;

        while (pointer <= right) {
            if (array[pointer] < 0) {
                swap(array, left++, pointer++);
            } else if (array[pointer] > 0) {
                swap(array, pointer, right--);
            } else {
                pointer++;
            }
        }

        return array;
    }

    private void swap (int [] array, int a , int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
