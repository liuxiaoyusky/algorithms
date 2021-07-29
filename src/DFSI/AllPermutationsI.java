package DFSI;

import java.util.ArrayList;
import java.util.List;

/*
Given a string with no duplicate characters, return a list with all permutations of the characters.

Assume that input string is not null.

Examples

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]

Set = "", all permutations are [""]
 */
public class AllPermutationsI {
    //no dup
    public List<String> permutations(String set) {
        List<String> ans = new ArrayList<>();
        //corner case
        if (set == null) {
            return ans;
        }

        //corner case
        if (set.length() == 0) {
            ans.add("");
            return ans;
        }

        permutationsHelper(set.toCharArray(), 0, ans);
        return ans;
    }

    private void permutationsHelper (char [] array, int index, List<String> ans) {
        //base case
        if (index == array.length - 1) {
            ans.add(new String(array));
            return;
        }

        for (int i = index; i < array.length; i++) {
            swap(array, i , index);
            permutationsHelper(array, index + 1, ans);
            //backtrack
            swap(array, i , index);
        }
    }

    private void swap(char [] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
