package 刷题;

public class MergeSort {
    //input: int [] array
    //output: int [] array
    public int [] mergeSort(int [] array) {
        int [] helper = new int[array.length];//helper to save the result of sorting
        //define the sorting space by [left,right]
        int left = 0;
        int right = array.length - 1;
        split(array, helper, left, right);

        return array;
    }

    //split array to two smaller arrays, then do mergesort on both smaller array
    private void split(int [] array, int [] helper, int left, int right) {
        //base case: smallest range that no need to do further split
        if (right - left == 0 || left > right) {
            return;
        }

        //general case
        //smaller problem
        int mid = left + (right - left) / 2;
        split(array, helper, left, mid);
        split(array, helper, mid + 1, right);

        //use the answer of smaller problem, solver current problem
        merge(array, helper, left, mid, right);
    }

    //merge two sorted array
    private void merge(int [] array, int [] helper, int left, int mid, int right) {
        //use two pointers l, r, pointing at the begining of two subarray, save smaller one in helper[index],
        //use index to keep track of the location to save next element
        //if either pointer l, r out of bound, directly save the other pointer's value to helper[index]

        int l = left;
        int r = mid + 1;
        int index = left;
        while (index <= right) {
            if (l <= mid && r <= right) {
                if (array[l] < array[r]) {
                    helper[index] = array[l];
                    index++;
                    l++;
                } else {
                    helper[index] = array[r];
                    index++;
                    r++;
                }
            } else if (l <= mid) {
                helper[index] = array[l];
                index++;
                l++;
            } else {
                helper[index] = array[r];
                index++;
                r++;
            }
        }


        //copy back the sorted array from helper to array
        for (int i = left; i <= right; i++){
            array[i] = helper[i];
        }
    }
}
