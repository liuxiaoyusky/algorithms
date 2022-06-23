package aaaaaaaaa暂时不懂;

public class QuickSort {
    //in memory
    public static void quickSort(int [] array) {
        //corner case
        if (array == null || array.length < 2) {
            return;
        }

        //to simplify, choose the last one
        helper(array, 0, array.length - 1);
    }

    private static void helper(int [] array, int left, int right) {
        //base
        if (left == right || left - 1 == right) {
            return;
        }

        //general case, find the location of pivot
        int pivot = right;//2
        int pivot_value = array[pivot];//2
        int smaller_pointer = left;//[left, smaller-1], all element < pivot_value
        int larger_pointer = right - 1;//[larger + 1, right], all element > pivot
        while (smaller_pointer <= larger_pointer) {
            if(array[smaller_pointer] <= pivot_value) {
                smaller_pointer++;
            } else if (array[larger_pointer] > pivot_value) {
                larger_pointer--;
            } else {
                swap(array, smaller_pointer, larger_pointer);
                smaller_pointer++;
                larger_pointer--;
            }
        }
        //[left, largerpointer, smaller pointer, pivot]
        swap(array, smaller_pointer - 1, pivot);
        helper(array,left,smaller_pointer - 2);
        helper(array, smaller_pointer, right);
    }

    private static void swap(int [] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

//test case: array == null // array.length = 0,1 => already sort
//test case:[1,0,2] ==>[1,0,2] ==> []
