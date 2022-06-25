package 刷题.递归;
import java.util.*;

/*
Given a collection of numbers, nums,
 that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Constraints:
    1 <= nums.length <= 8
    -10 <= nums[i] <= 10

 */
public class PermutationsII47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = makeMap(nums);
        List<List<Integer>> ans = new LinkedList<>();
        Integer [] cur = new Integer[nums.length];
        helper(map, 0, cur, ans);
        return ans;
    }

    private void helper(Map<Integer, Integer> map, int index, Integer [] cur, List<List<Integer>> ans) {
        //base case
        if (index == cur.length) {
            ans.add(List.of(cur));
            return;
        }

        //general case
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value >= 1) {
                cur[index] = key;
                map.put(key,value - 1);
                helper(map, index + 1, cur, ans);

                //back track
                map.put(key,value);
            }
        }
    }

    private Map<Integer, Integer> makeMap(int [] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int cur : nums) {
            Integer value = map.get(cur);
            if (value == null) {
                value = 0;
            }
            map.put(cur, value + 1);
        }
        return map;
    }
}
