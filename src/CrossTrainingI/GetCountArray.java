package CrossTrainingI;

public class GetCountArray {
    public static int[] countArray(int [] array) {
        int [] indexArray = new int[array.length];//index of original array
        int [] countArray = new int[array.length];//result to return
        int [] helper = new int[array.length];//help merge
        for (int i = 0; i < array.length; i++) {
            indexArray[i] = i;
        }
        mergeSort(array, indexArray, countArray, helper, 0, array.length - 1);
        return countArray;
    }

    private static  void mergeSort(int [] array, int [] indexArray,
                                   int [] countArray, int [] helper, int left, int right) {
        //base case
        if (left >= right) {
            return;
        }

        //general case
        //split
        int mid = left + (right - left) / 2;
        mergeSort(array, indexArray, countArray, helper, left, mid);
        mergeSort(array, indexArray, countArray, helper, mid + 1, right);


        //merge
        for (int i = left; i <= right; i++) {
            helper[i] = indexArray[i];
        }

        int l = left;
        int r = mid + 1;
        int cur = left;
        while(l <= mid) {
            if (r > right || array[helper[l]] <= array[helper[r]]) {
                countArray[helper[l]] += (r - mid - 1);
                indexArray[cur++] = helper[l++];
            } else {
                indexArray[cur++] = helper[r++];
            }
        }
    }
}
