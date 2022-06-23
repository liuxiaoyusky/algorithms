package 刷题.递归;

import filesystem.Entry;

import java.util.*;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[[1,1,6],[1,2,5],[1,7],[2,6]]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output:
[[1,2,2],[5]]

Constraints:
    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    1 <= target <= 30

 */
public class CombinationSumII {
    //input int unsorted array with dup, int target, every element use at most once
    //output List<List<Integer>>
    //solution: every element can be in or out, if current combination == target, save in ans
    //avoid dup: sort the array first,for element with same value, each amount only consider once
    //prune: if current element makes combination larger, stop further looking including current element
    //time: O(2^n), space:O(n)
    public List<List<Integer>> combinationSum2(int [] array, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        Arrays.sort(array);
        helper(array, target,0, cur, ans);
        return ans;
    }

    private void helper(int [] array, int target, int index, List<Integer> cur, List<List<Integer>> ans) {
        //base case
        if (target == 0) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        //corner case
        if (index >= array.length) {
            return;
        }

        if (target < 0) {
            return;
        }



        //general case
        int curValue = array[index];
        int next = index + 1;
        int count = 1;
        while (next < array.length) {
            if (array[next] == curValue) {
                next++;
                count++;
            } else {
                break;
            }
        }

        for (int i = 1; i <= count; i++) {
            cur.add(curValue);
            helper(array,target - i * curValue, next, cur, ans);
        }


        //back track
        for (int i = 1; i <= count; i++) {
            cur.remove(cur.size() - 1);
        }
        helper(array, target, next, cur, ans);
    }
}
