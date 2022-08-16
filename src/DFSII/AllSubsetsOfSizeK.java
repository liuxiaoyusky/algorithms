package DFSII;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K.

Assumptions

There are no duplicate characters in the original set.

​Examples

Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

Set = "", K = 0, all the subsets are [""].

Set = "", K = 1, all the subsets are [].
 */
public class AllSubsetsOfSizeK {
    public List<String> subSetsOfSizeK(String set, int k) {
        List<String> list = new ArrayList<>();
        if (set == null) {
            return list;
        }

        StringBuilder sb = new StringBuilder();
        helper(set, sb, 0, k, list);

        return list;
    }

    private void helper(String set, StringBuilder sb, int index, int k, List<String> list) {
        //base case
        if (sb.length() == k) {
            list.add(new String(sb));
            return;
        }

        //corner case
        if (index == set.length()) {
            return;
        }

        //general case
        char cur = set.charAt(index);
        sb.append(cur);
        helper(set, sb, index + 1, k, list);

        //backtrack
        sb.deleteCharAt(sb.length() - 1);
        helper(set, sb, index + 1, k, list);
    }
}
