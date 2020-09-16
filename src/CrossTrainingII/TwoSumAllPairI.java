package CrossTrainingII;

import java.util.*;

/*
Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.

Assumptions

    The given array is not null and has length of at least 2
    The order of the values in the pair does not matter

Examples

    A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
 */

//input: array, target output: distinct pairs of values: List<List<Integer>>
public class TwoSumAllPairI {
    //my solution: time n, space n, n is the length of array
    public List<List<Integer>> allPairs(int[] array, int target) {
        // Assumptions: array is not null, array.length >= 2, nt sorted, with dup elements
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // key : number
        //value: list of all possible indices
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> indices = map.get(target - array[i]);
            // if target - array[i] is in the map,
            // we can get all the pairs(j,i), with i as the larger index.
            if (indices != null) {
                for (int j: indices) {
                    result.add(Arrays.asList(j,i));
                }
            }

            //add current index i to all the possible indices for value of array[i]
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);
        }
        return result;
    }

    //solution 2: using hashMap
    public List<List<Integer>> allPairsII(int [] array, int target) {
        //Assumption: array is not null, array.length >= 2
        List<List<Integer>> result = new ArrayList<>();
        //Record the number of existence of the values
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : array) {
            //Two cases when we need to make the pair a solution:
            //1. if 2*x == target, we need to make sure there is no dup
            //2. if x + y == target, and this is the first time both x and y are present,
            //so we can make sure no dup

            Integer count = map.get(num);
            if (num * 2 == target && count != null && count == 1) {
                result.add(Arrays.asList(num,num));
            } else if (map.containsKey(target - num) && count == null) {
                result.add(Arrays.asList(target - num, num));
            }
            if (count == null) {
                map.put(num,1);
            } else {
                map.put(num,count + 1);
            }
        }
        return result;
    }

    //solution 3: sort and two pointers, in place
    public List<List<Integer>> allPairsIII(int [] array, int target) {
        //Assumption: array is not null, array.length >= 2
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // ignore all the consecutive dup values
            if (left > 0 && array[left] == array[left - 1]) {
                left++;
                continue;
            }
            int cur = array[left] + array[right];
            if (cur == target) {
                result.add(Arrays.asList(array[left],array[right]));
                left++;
                right--;
            } else if (cur < target){
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
