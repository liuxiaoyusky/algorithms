package DFSI;

import java.util.ArrayList;
import java.util.List;
/*
Given N pairs of parentheses “()”, return a list with all the valid permutations.

Assumptions

    N > 0

Examples

    N = 1, all valid permutations are ["()"]
    N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 */
public class AllValidPermutationsOfParenthesesI {
    public List<String> validParentheses(int n) {
        List <String> ans = new ArrayList<String>();

        //corner case
        if (n < 0) {
            return ans;
        }

        StringBuilder helper = new StringBuilder();
        validParenthesesHelper(n, n, helper, ans);
        return ans;
    }

    private void validParenthesesHelper(int left, int right, StringBuilder helper, List<String> ans) {
        //base case
        if (left == 0 && right == 0) {
            ans.add(helper.toString());
            return;
        }

        if (left > 0) {
            helper.append('(');
            validParenthesesHelper(left - 1, right, helper, ans);

            //backtrack
            helper.deleteCharAt(helper.length() - 1);
        }

        if (right > left) {
            helper.append(')');
            validParenthesesHelper(left, right - 1, helper, ans);

            //backtrack
            helper.deleteCharAt(helper.length() - 1);
        }
    }
}
