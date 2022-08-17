package DFSII;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}, subject to the priority restriction: {} higher than <> higher than ().


Assumptions

    l, m, n >= 0

    l + m + n >= 0


Examples

    l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "<()>", "<>()"].

    l = 2, m = 0, n = 1, all the valid permutations are [“()(){}”, “(){()}”, “(){}()”, “{()()}”, “{()}()”, “{}()()”].
 */
public class AllValidPermutationsOfParenthesesIII {
    //now add left need to check if anything in stack, if something in stack, add when index is larger
    public List<String> validParenthesesIII(int l, int m, int n) {
        int length = 2 * (l + m + n);
        List<String> ans = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char [] chars = new char [] {'{','}','<','>','(',')'};
        int  [] ints = new int [] {n , n, m, m, l , l};
        helper(ints, chars, length, sb, stack, ans);
        return ans;
    }

    private void helper(int [] ints, char [] chars, int length, StringBuilder sb,
                        Deque<Integer> stack, List<String> ans) {
        //base case
        if (sb.length() == length) {
            ans.add(new String(sb));
            return;
        }

        for(int i = 0; i < ints.length; i++) {
            //left
            if (i % 2 == 0) {
                if (ints[i] > 0 && (stack.isEmpty() || i > stack.peek())){
                    ints[i]--;
                    sb.append(chars[i]);
                    stack.push(i);
                    helper(ints, chars, length, sb, stack, ans);

                    //backtrack
                    ints[i]++;
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pop();
                }
            }

            //right
            else {
                if (ints[i] > ints[i - 1] && stack.peek() == i - 1) {
                    ints[i]--;
                    sb.append(chars[i]);
                    Integer cur = stack.pop();
                    helper(ints, chars, length, sb, stack, ans);

                    //backtrack
                    ints[i]++;
                    sb.deleteCharAt(sb.length() - 1);
                    stack.push(cur);
                }
            }
        }
    }
}
