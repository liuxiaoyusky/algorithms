package 刷题.递归;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    Only numbers 1 through 9 are used.
    Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the
combinations may be returned in any order.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

Constraints:
    2 <= k <= 9
    1 <= n <= 60
 */
public class CombinationSumIII {
    //pick from the largest possible value, and only select from smaller value
    //input:n, k
    //output: list of list of int
    public List<List<Integer>> combinationSum3(int k, int n) {
        List <Integer> curCombination = new ArrayList<>(k);
        List<List<Integer>> ans = new LinkedList<>();
        helper(k, n,1, curCombination, ans);
        return ans;
    }

    private void helper(int k, int n, int cur, List <Integer> curCombination, List<List<Integer>> ans) {
        //base case
        if (curCombination.size() == k && n == 0) {
            ans.add(List.copyOf(curCombination));
            return;
        }

        //corner case, no possible element
        if (cur > 9) {
            return;
        }

        //general case
        for (int i = cur; i <= 9 - (k - curCombination.size()) + 1; i++) {
            curCombination.add(i);
            helper(k, n - i,i + 1, curCombination, ans);
            curCombination.remove(curCombination.size() - 1);
        }
    }
}
