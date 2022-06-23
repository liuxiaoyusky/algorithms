package 刷题.递归;

import java.util.LinkedList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is
less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []


Constraints:
    1 <= candidates.length <= 30
    1 <= candidates[i] <= 200
    All elements of candidates are distinct.
    1 <= target <= 500
 */
public class CombinationSum {
    //input: int [] elements, int target
    //output: List<List> string
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        int [] elementsNum = new int[candidates.length];
        helper(candidates, target, 0,  elementsNum, ans);
        return ans;
    }

    //for each candidates, from the maximum number to none, and go next candidates, until target == 0
    private void helper(int [] candidates, int target, int index, int [] elementsNum, List<List<Integer>> ans) {
        //base case
        if (target == 0) {
            List<Integer> solution = new LinkedList<>();//[7]
            for (int i = 0; i < candidates.length; i++) {//[0,0,0,0]
                for (int j = 1; j <= elementsNum[i]; j++) {
                    solution.add(candidates[i]);
                }
            }
            ans.add(solution);
            return;
        }

        //corner case
        if (index == candidates.length) {
            return;
        }

        //general case
        int cur = candidates[index];
        int max = target / cur;
        for (int i = 0; i <= max; i++) {//1, target == 0, index = 4
            elementsNum[index] = i;
            helper(candidates, target - cur * i, index + 1, elementsNum, ans);
        }

        //backtrack
        elementsNum[index] = 0;
    }
}
