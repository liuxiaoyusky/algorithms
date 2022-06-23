package Atlas;


//use helper to temporarily save the answer after merge and replace the original
//assume sort in ascending order, assume all input can be stored in memory
//assume the sorting content is just int
//let the length of array is n, then the Time complexity is: O(nlogn) Space complexity is O(n)
public class MergeSort {
    public int [] mergeSort(int [] array) {
        int [] helper = new int [array.length];
        split(array,helper,0,array.length - 1);
        return array;
    }
    //sorting range: [left, right]
    //helper function to split
    private void split(int [] array, int [] helper, int left, int right) {
        //base case, 0 or 1 element
        if (right <= left) {
            return;
        }

        int mid = left + (right - left) / 2;
        split (array, helper, left, mid);
        split (array, helper, mid + 1, right);

        //merge
        merge(array, helper, left, mid, right);
    }

    //copy original data in range[left, right] to helper array, and merge it in ascending order
    private void merge(int [] array, int [] helper, int left, int mid, int right) {
        int first = left;
        int second = mid + 1;
        int firstValue = array[first];
        int secondValue = array[second];
        int curPointer = left;
        while (curPointer <= right) {
            if (first > mid) {
                firstValue = Integer.MAX_VALUE;
            } else {
                firstValue = array[first];
            }

            if (second > right) {
                secondValue = Integer.MAX_VALUE;
            } else {
                secondValue = array[second];
            }

            if (firstValue < secondValue) {
                helper[curPointer] = firstValue;
                first++;
            } else {
                helper[curPointer] = secondValue;
                second++;
            }
            curPointer++;
        }

        //save back to array
        for (int i = left; i <= right; i++) {
            array[i] = helper[i];
        }
    }
}
