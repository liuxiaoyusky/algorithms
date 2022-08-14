package DFSII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.

Assumptions

    There could be duplicate characters in the original set.

Examples
    Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
    Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
    Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
    Set = "", all the subsets are [""]
    Set = null, all the subsets are []
 */
public class AllSubsetsII {
    //dup number, need sorted
    public List<String> subSets(String set) {
        List<String> list = new LinkedList<>();

        //corner case
        if (set == null) {
            return list;
        }

        StringBuilder sb = new StringBuilder();
        char [] array = set.toCharArray();
        Arrays.sort(array);
        helper(array, 0, sb, list);
        return list;
    }

    private void helper(char [] set, int index, StringBuilder sb, List<String> list) {
        //base case
        if (index == set.length) {
            list.add(new String(sb));
            return;
        }

        char cur = set[index];
        sb.append(cur);
        helper(set, index + 1, sb, list);

        //backtrack
        sb.deleteCharAt(sb.length() - 1);
        while (index < set.length - 1 && set[index + 1] == cur) {
            index++;
        }

        helper(set, index + 1, sb, list);
    }
}
