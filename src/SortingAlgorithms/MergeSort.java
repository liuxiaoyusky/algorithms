package SortingAlgorithms;

//use helper to temporarily save the answer after merge and replace the original
public class MergeSort {
    public int [] mergeSort(int [] array) {
        //corner case
        if (array == null || array.length == 0) {
            return array;
        }

        int [] helper = new int[array.length];
        mergeSort(array, 0, array.length - 1, helper);
        return array;
    }

    //this is the recursion function
    private void mergeSort(int [] array, int left, int right, int [] helper) {
        //base case : only 0 or 1 element left
        if((right - left) <= 0) {
            return;
        }

        //sub-problems
        int mid = left + (right - left) / 2;
        mergeSort(array,left,mid,helper);
        mergeSort(array,mid + 1, right, helper);

        //assume sub-problem solved, use their answer to solve current one
        //which is: merge two arrays to one
        merge(array,left, mid, right, helper);
    }

    //this is the helper function for merge
    private void merge(int [] array, int left, int mid, int right, int [] helper) {
        int l = left;
        int r = mid + 1;
        for(int i = left; i <= right; i++) {
            if (l <= mid && r <= right) {
                if (array[l] < array[r]) {
                    helper[i] = array[l];
                    l++;
                } else {
                    helper[i] = array[r];
                    r++;
                }
            } else if (l <= mid) {
                helper[i] = array[l];
                l++;
            } else {
                helper[i] = array[r];
                r++;
            }
        }

        for (int i = left; i <= right; i++) {
            array[i] = helper[i];
        }
    }
}
