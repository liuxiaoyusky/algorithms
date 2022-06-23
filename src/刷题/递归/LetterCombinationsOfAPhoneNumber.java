package 刷题.递归;

import java.util.LinkedList;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsOfAPhoneNumber {
    //input string of digits
    //output, list of string
    //assume all inputs are valid
    public List<String> letterCombinations(String digits) {
        String [] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        List<String> ans = new LinkedList<>();
        helper(digits, 0, sb, map, ans);
        return ans;
    }

    private void helper(String digits, int index, StringBuilder sb, String [] map, List<String> ans) {
        //corner case
        if (digits.length() == 0) {
            return;
        }

        //base case
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        //general case
        int digit = digits.charAt(index) - '0';
        String keys = map[digit];
        for (int i = 0; i < keys.length(); i++) {
            sb.append(keys.charAt(i));
            helper(digits, index + 1, sb, map, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
