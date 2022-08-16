package DFSII;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

    l, m, n >= 0
    l + m + n > 0

Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
 */
public class AllValidPermutationsOfParenthesesII {
    //do it by dfs
    //assume not negative numbers
    //left can be added freely
    //right can be added when:
    //1:right<left and 2: same kind with last left
    public List<String> validParentheses(int l, int m, int n) {
        List<String> ans = new LinkedList<>();
        char [] chars = new char [] {'(',')', '<','>', '{', '}'};
        int [] ints = new int [] {l, l, m, m, n, n};
        Deque<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        helper(chars, ints, stack, sb, 2 * (l + m + n), ans);
        return ans;
    }

    private void helper(char [] chars, int [] ints, Deque<Character> stack, StringBuilder sb,
                        int total, List<String> ans) {
        //base case
        if (sb.length() == total) {
            ans.add(new String(sb));
            return;
        }

        for (int i = 0; i < ints.length; i++) {
            //for all left, add freely
            if (i % 2 == 0) {
                if (ints[i] > 0) {
                    sb.append(chars[i]);
                    stack.push(chars[i]);
                    ints[i]--;
                    helper(chars, ints, stack, sb, total, ans);

                    //backtrack
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pop();
                    ints[i]++;
                }
            } else {
                if (ints[i - 1] < ints[i] && !stack.isEmpty() && stack.peek() == chars[i - 1]) {
                    sb.append(chars[i]);
                    char left = stack.pop();
                    ints[i]--;
                    helper(chars, ints, stack, sb, total, ans);

                    //backtrack
                    sb.deleteCharAt(sb.length() - 1);
                    stack.push(left);
                    ints[i]++;
                }
            }
        }
    }
}
