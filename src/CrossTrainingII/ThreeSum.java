package CrossTrainingII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Determine if there exists three elements in a given array that sum to the given target number.
Return all the triple of values that sums to target.
Assumptions
    The given array is not null and has length of at least 3
    No duplicate triples should be returned, order of the values in the tuple does not matter
Examples
    A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
 */
public class ThreeSum {
    //assume array not null, array.length >= 3
    //for each number, save a list of two sums
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int temp = array[left] + array[right];
                if (temp + array[i] == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                }

                else if (temp + array[i] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
