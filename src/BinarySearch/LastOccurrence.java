package BinarySearch;

public class LastOccurrence {
    //ascending sorted, dup, return last
    public int lastOccur(int[] array, int target) {
        //corner case
        if (array == null || array.length == 0) {
            return -1;
        }

        //define searching space
        int left = 0;
        int right = array.length - 1;

        //search every element in searching space
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                while (mid < right && target == array[mid + 1]) {
                    mid++;
                }
                return array[right] == target ? right : mid;
            } else if (array[mid] < target) {
                //target in right half
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

