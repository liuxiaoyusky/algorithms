package 刷题.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.



Constraints:

    3 <= nums.length <= 3000
    -105 <= nums[i] <= 105


 */
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int [] nums) {
        //corner case
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> ans = twoSums(nums,i + 1, nums.length - 1, - nums[i]);
            for (List<Integer> ls : ans) {
                result.add(ls);
            }
            while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    private List<List<Integer>> twoSums(int [] nums, int left, int right, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ans.add(List.of(nums[left], nums[right], -target));
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                left++;
            } else if (nums[left] + nums[right] < target) {
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                left++;
            } else {
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                right--;
            }

        }
        return ans;
    }
    //----------------------------------------------------------------------
    //input: int array
    //output: List<List<Integer>> values that sum is 0
    public List<List<Integer>> threeSumII(int [] array) {
        List<Integer> solution = new ArrayList<>(3);
        List<List<Integer>> result = new LinkedList<>();
        //corner case
        if (array == null || array.length <= 2) {
            return List.of(solution);
        }

        Arrays.sort(array);
        //two pointer, left, right
        //goal: array[left] + a[Right] + a[i] = 0
        // i < left < right
        //prune: if a[l] + a[r] < -a[i], l dedup and l++
        //if a[l] + a[r] > -a[i], r dedup and r--
        //else equal, add to list
        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                if (array[left] + array[right] + array[i] == 0) {
                    solution.add(array[left]);
                    solution.add(array[right]);
                    solution.add(array[i]);
                    result.add(solution);
                    solution = new ArrayList<>(3);
                    while(left < array.length - 1 && array[left] == array[left + 1]) {
                        left++;
                    }
                    left++;
                } else if (array[left] + array[right] + array[i] < 0) {
                    while(left < array.length - 1 && array[left] == array[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    while(right > i + 1 && array[right] == array[right - 1]) {
                        right--;
                    }
                    right--;
                }
            }
            while(i < array.length - 3 && array[i] == array[i + 1]) {
                i++;
            }
        }
        return result;
    }
}
