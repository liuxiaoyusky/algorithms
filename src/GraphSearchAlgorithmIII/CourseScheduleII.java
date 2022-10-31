package GraphSearchAlgorithmIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {
    //there could be more than two prerequisite
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // given no dup, assume valid input
        //corner case
        if (numCourses <= 0 || prerequisites == null) {
            return new int [0];
        }

        //build a map as available-pre to see the relations, put the number that doesn't appear in the prerequisites
        //as the courses that doesn't have any prerequisite and could be done ahead, track by boolean []
        boolean [] available = new boolean [numCourses];

        for (int i = 0; i < available.length; i++) {
            available[i] = true;
        }

        Map<Integer, List<Integer>> relations = new HashMap<>();
        for (int [] pre: prerequisites) {
            int notAvailableIndex = pre[0];
            available[notAvailableIndex] = false;
            int requireIndex = pre[1];
            List<Integer> list = relations.get(notAvailableIndex);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(requireIndex);
            relations.put(notAvailableIndex, list);
        }


        //track return order
        int index = 0;
        int [] ans = new int [numCourses];

        //init
        for (int i = 0; i < ans.length; i++) {
            if (available[i]){
                ans[index] = i;
                index++;
            }
        }


        //map saves all pairs that a list of all courses that one prerequisite course can fulfill
        //if prerequisite is available, remove the entry, put all things in the list available and into ans
        int previousIndex = -1;
        while (index <= numCourses - 1) {
            //if not updated(not available to slove)
            if (previousIndex == index) {
                return new int [0];
            }
            previousIndex = index;
            for (Integer key:relations.keySet()) {
                //not yet been fulfilled
                if (!available[key]) {
                    List<Integer> list = relations.get(key);
                    boolean able = true;
                    for (Integer i : list) {
                        if (!available[i]) {
                            able = false;
                        }
                    }
                    if (able) {
                        available[key] = true;
                        ans[index] = key;
                        index++;
                    }
                }
            }
        }

        return ans;

    }
}
