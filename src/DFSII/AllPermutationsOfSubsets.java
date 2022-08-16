package DFSII;

import java.util.ArrayList;
import java.util.List;

/*
Given a string with no duplicate characters, return a list with all permutations of the string and all its subsets.


Examples

Set = “abc”, all permutations are [“”, “a”, “ab”, “abc”, “ac”, “acb”, “b”, “ba”, “bac”, “bc”, “bca”, “c”, “cb”, “cba”, “ca”, “cab”].

Set = “”, all permutations are [“”].

Set = null, all permutations are [].
 */
public class AllPermutationsOfSubsets {
    //rising size from 0 to set.length(), for each size, find all permutations with given letters in set
    public List<String> allPermutationsOfSubsets(String set) {
        List<String> ans = new ArrayList<>();
        char [] array = set.toCharArray();
        for (int i = 0; i <= set.length(); i++) {
            helper(array, 0, i, ans);
        }
        return ans;
    }

    private void helper(char [] array, int index, int k, List<String> ans) {
        //base case
        if (index == k) {
            ans.add(new String(array, 0, k));
            return;
        }

        //general case
        for (int i = index; i < array.length; i++) {
            swap(array, i, index);
            helper(array, index + 1, k, ans);

            //backtrack
            swap(array, i, index);
        }
    }

    private void swap(char [] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
