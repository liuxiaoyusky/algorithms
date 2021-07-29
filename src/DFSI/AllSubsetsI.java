package DFSI;

import java.util.ArrayList;
import java.util.List;

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
