package 刷题.递归;

import java.util.LinkedList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome
 partitioning of s.
A palindrome string is a string that reads the same backward as forward.


Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:
    1 <= s.length <= 16
    s contains only lowercase English letters.

 */
public class PalindromePartitioning131 {
    //clarification: consistant order, each substring must be palindrome
    //naive way: for for for loop => go through every possible combination of substrings
    //every space between two chars can make a split
    //turn in recursive to achieve this goal
    //smaller problem: when left part is palindrome, how about right part(smaller problem)?
    //index i means start from string[index] and look backwards
    //rule: for each i, make a split after string[i - 1], if [start, i) left part is a palindrome,
    // go check [i+1,] at next layer
    //base case, start index == string.length - 1(after last char) , put current combination to ans

    //input:String, output:
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        List<String> curSol = new LinkedList<>();
        helper(s,0,ans,curSol);
        return ans;
    }

    private void helper(String s, int index, List<List<String>> ans, List<String> curSol) {
        //base case, all left part are palindrome
        if (index >= s.length()) {
            ans.add(new LinkedList<>(curSol));
            return;
        }

        //general case
        for (int i = index + 1; i <= s.length(); i++) {
            String cur = s.substring(index, i);//[index, i)
            if (isPalindrome(cur)) {
                curSol.add(cur);
                helper(s,i,ans,curSol);

                //backtrack
                curSol.remove(curSol.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
