package 刷题.递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
    1 <= nums.length <= 10
    -10 <= nums[i] <= 10

 */
public class SubsetII {
    //sort first, fo each element i, check all different amount of this element, and go next element
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        Arrays.sort(nums);
        helper(nums, 0, cur, ans);
        return ans;
    }

    private void helper(int [] nums, int index, List<Integer> cur, List<List<Integer>> ans) {
        //base case
        if (index == nums.length) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        //general case
        int curValue = nums[index];
        int count = 1;
        int next = index + 1;
        while (next < nums.length && nums[next] == curValue) {
            count++;
            next++;
        }

        for (int i = 1; i <= count; i++) {
            cur.add(curValue);
            helper(nums,next,cur,ans);
        }

        //back track
        for (int i = 1; i <= count; i++) {
            cur.remove(cur.size() - 1);
        }
        helper(nums,next,cur,ans);
    }
}
