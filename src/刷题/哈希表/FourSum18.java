package 刷题.哈希表;

import java.util.*;

/*
18. 4Sum
Medium

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]



Constraints:

    1 <= nums.length <= 200
    -109 <= nums[i] <= 109
    -109 <= target <= 109


 */
public class FourSum18 {
    //input: int [] nums
    //output: list of pairs
    //need to dedup
    class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public List<List<Integer>> fourSum(int [] nums, int target) {
        Map<Long, List<Pair>> map = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long sum = nums[i] + nums[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>(Arrays.asList(new Pair(i, j))));
                }
                else {
                    map.get(sum).add(new Pair(i, j));
                }
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        for (int j = 1; j < nums.length; j++) {
            while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j++;
            }
            for (int i = 0; i < j; i++) {
                while (i < j - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
                long sum = nums[i] + nums[j];
                if (map.containsKey(target - sum)) {
                    for (Pair pair:map.get(target - sum)) {
                        if (pair.second < i) {
                            result.add(List.of(nums[pair.first], nums[pair.second],nums[i], nums[j]));
                        }
                    }
                }
            }
        }
        return result;
    }
}
