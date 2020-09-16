package CrossTrainingII;

import java.util.*;

public class TwoSumAllPairII {
    //my solution: Time:O(n) Space: O(n)
    //input: array, target output: distinct pairs of values: List<List<Integer>>
    public List<List<Integer>> allPairs(int[] array, int target) {
        //assme array not null, array.length > 2, not sorted, with dup
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();//unique elements in array
        boolean half = false;
        for (int cur: array) {
            Boolean copy = set.contains(cur);
            //if an element exists in set, unless it's
            if (!copy) {
                Boolean partner = set.contains(target - cur);
                if (partner) {
                    ans.add(Arrays.asList(cur,target - cur));
                }
                set.add(cur);
            } else if ( half == false && cur + cur == target ) {
                half = true;
                ans.add(Arrays.asList(cur, cur));
            }
        }
        return ans;
    }
}