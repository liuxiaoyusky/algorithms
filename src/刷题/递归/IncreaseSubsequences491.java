package 刷题.递归;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
Given an integer array nums, return all the different possible increasing subsequences of the given array with at least
two elements. You may return the answer in any order.
The given array may contain duplicates, and two equal integers should also be considered a special case of increasing
 sequence.

Example 1:
Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

Example 2:
Input: nums = [4,4,3,2,1]
Output: [[4,4]]

Constraints:
    1 <= nums.length <= 15
    -100 <= nums[i] <= 100

 */
public class IncreaseSubsequences491 {
    //rule: for each start index i, looking for j in [i + 1,] such that nums[i] <= nums[j], then take j as start index for next layer
    //dedup: for each layer, for each j, add j to set, so if set.contains[j], skip
    //base case: at least two element


    //input: int [] nums
    //output: List<List<Integer>>
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        helper(nums, -1, ans, cur);
        return ans;
    }


    private void helper(int [] nums, int start, List<List<Integer>> ans, List<Integer> cur) {
        //base case
        if (cur.size() >= 2) {
            ans.add(new LinkedList<>(cur));
        }


        //dedup
        Set<Integer> set = new HashSet<>();
        //general case
        for (int i = start + 1; i < nums.length; i++) {
            int curValue = nums[i];
            if ((start == -1 || nums[start] <= curValue) && !set.contains(curValue)) {
                cur.add(curValue);
                set.add(curValue);
                helper(nums,i,ans,cur);

                //backtrack
                cur.remove(cur.size() - 1);
            }
        }
    }
}
