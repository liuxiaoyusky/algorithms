package CrossTrainingDIY;

public class SearchInShiftedSortedArrayII {
    //keep track of the leftMost value and rightMost value
    //left most < largest < smallest < rightMost
    //0       < k <       < k+ 1<     length - 1
    // -------f----------- ---------s-----------
    //for the pivot: if pivot < leftMost, arrived shift value, if target < leftMost && target
    public int search(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int rightMost = array[right];
        if (array[0] == target) {
            return 0;
        } else if (array[array.length - 1] == target) {
            return array.length - 1;
        }
        while (left <= right) {
            int mid = left + (right - left)/ 2;
            if (array[mid] == target) {
                while (mid > 0 && target == array[mid - 1]) {
                    mid--;
                }
                return mid;
            }
            //case 1 array[mid] in F, target in S
            else if(array[mid] > rightMost && target < rightMost) {
                left = mid + 1;
            }

            //case 2: array[mid] in S, target in F
            else if(array[mid] < rightMost && target > rightMost) {
                right = mid - 1;
            }

            //case 3: array[mid] and target both in F
            else if (array[mid] < rightMost && target < rightMost) {
                if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            //case 4: array[mid] and target both in S
            else if (array[mid] > rightMost && target > rightMost) {
                if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            //case 5: mid = rightmost = target, no info, linear scan
            else {
                if (array[left] != target) {
                    left++;
                } else {
                    return left;
                }
            }
        }
        return -1;
    }
}
