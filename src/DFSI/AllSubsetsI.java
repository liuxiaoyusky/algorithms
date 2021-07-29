package DFSI;

import java.util.ArrayList;
import java.util.List;
/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.
Assumptions
    There are no duplicate characters in the original set.
​Examples
    Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
    Set = "", all the subsets are [""]
    Set = null, all the subsets are []
 */
public class AllSubsetsI {
    public List<String> subSets(String set) {
        List<String> ans = new ArrayList<String>();
        //corner case
        if (set == null) {
            return ans;
        }

        //use stringbuilder for space saving
        StringBuilder helper = new StringBuilder();
        subSetsHelper(set, helper, 0, ans);
        return ans;
    }

    private void subSetsHelper(String set, StringBuilder helper, int index, List<String> ans) {
        //base case
        if (index == set.length()) {
            ans.add(helper.toString());
            return;
        }

        helper.append(set.charAt(index));
        subSetsHelper(set, helper, index + 1, ans);

        //backtrack
        helper.deleteCharAt(helper.length() - 1);
        subSetsHelper(set, helper, index + 1, ans);
    }
}
