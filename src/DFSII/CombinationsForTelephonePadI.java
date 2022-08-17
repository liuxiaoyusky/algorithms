package DFSII;

import java.util.ArrayList;
import java.util.List;

/*
Given a telephone keypad, and an int number, print all words which are possible by pressing these numbers, the output strings should be sorted.

{0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"}

Assumptions:

    The given number >= 0

Examples:

if input number is 231, possible words which can be formed are:

[ad, ae, af, bd, be, bf, cd, ce, cf]
 */
public class CombinationsForTelephonePadI {
    public String[] combinations(int number) {
        String [] keys = new String [] {"", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        char [] array = Integer.toString(number).toCharArray();
        helper(array, 0, keys, sb, ans);
        String [] ansArray = new String [ans.size()];
        for(int i = 0; i < ansArray.length; i++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }

    private void helper(char [] array, int index, String [] keys, StringBuilder sb,
                        List<String> ans) {
        //base case
        if (index == array.length) {
            ans.add(new String(sb));
            return;
        }

        int cur = array[index] - '0';
        if (cur <= 1) {
            helper(array, index + 1, keys, sb, ans);
            return;
        }

        String key = keys[cur];
        for(int i = 0; i < key.length(); i++) {
            sb.append(key.charAt(i));
            helper(array, index + 1, keys, sb, ans);

            //backtrack
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
