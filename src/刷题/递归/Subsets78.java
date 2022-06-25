package 刷题.递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.

 */
public class Subsets78 {
    //input: int [] arrays
    //output: List<List<Integer>>
    public List<List<Integer>> subsets(int [] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curSubset = new ArrayList<>();
        helper(nums, 0, curSubset, ans);
        return ans;
    }

    private void helper(int [] nums, int index, List<Integer> curSubset, List<List<Integer>> ans) {
        //base case
        if (index == nums.length) {
            ans.add(new LinkedList<>(curSubset));
            return;
        }

        //general case:add this or not
        curSubset.add(nums[index]);
        helper(nums, index + 1, curSubset, ans);

        //backtrack
        curSubset.remove(curSubset.size() - 1);
        helper(nums, index + 1, curSubset, ans);
    }
}
