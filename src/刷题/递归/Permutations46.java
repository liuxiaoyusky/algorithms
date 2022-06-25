package 刷题.递归;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]

Constraints:
    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.

 */
public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Integer [] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }
        helper(array, 0, ans);
        return ans;
    }

    private void helper(Integer [] nums, int index, List<List<Integer>> ans) {
        //base case
        if (index == nums.length) {
            ans.add(List.of(nums));//List.of is immutable, Arrays.asList() is mutable
            return;
        }

        //general case
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            helper(nums, index + 1, ans);
            swap(nums, i, index);
        }
    }

    private void swap(Integer [] nums, int a, int b) {
        Integer temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
