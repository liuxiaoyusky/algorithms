package Graph;

import java.util.*;

public class TopologicalOrder5 {
    //https://leetcode.com/problems/course-schedule/

    public int [] findOrderBFS(int numCourses, int [][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) {
            return new int [0];
        }

        //build the map while counting the prerequisite they left, key = prerequisite, value = list of courses depend on it
        //reverse map of dfs
        //if a course finished, we know what courses are free to learn now
        int [] indegree = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int [] pair: prerequisites) {
            int independent = pair[1];
            int dependent = pair[0];
            List<Integer> dependents = map.get(independent);
            if (dependents == null) {
                dependents = new ArrayList<>();
                map.put(independent, dependents);
            }
            dependents.add(dependent);

            indegree[dependent]++;
        }

        //only saves courses able to finish now
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        int [] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int finished = queue.poll();
            order[count] = finished;
            List<Integer> dependents = map.get(finished);
            if (dependents != null) {
                for (int dependent : dependents) {
                    indegree[dependent]--;
                    if (indegree[dependent] == 0) {
                        queue.offer(dependent);
                    }
                }
            }

            count++;
        }



        if (count == numCourses) {
            return order;
        } else {
            return new int [0];
        }
    }


    public int[] findOrderDFS(int numCourses, int [][] prerequisites) {
        //build graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        buildMap(map, prerequisites);

        //dfs traverse and make the schedule
        List<Integer> order = new ArrayList<>(numCourses);
        boolean [] visiting = new boolean[numCourses];
        boolean [] visited = new boolean [numCourses];


        for (int i = 0; i < numCourses; i++) {
            //if return false, meet a loop and no order can be generated, return new order
            if (!dfs(i, map, visiting, visited, order)) {
                return new int[0];
            }
        }

        //convert the list to array
        int [] ans = new int [numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = order.get(i);
        }

        return ans;
    }


    private boolean dfs(int course, Map<Integer, List<Integer>> map, boolean [] visiting, boolean [] visited,
                        List<Integer> order){
        if (visited[course]) {
            return true;
        }

        //loop
        if (visiting[course]) {
            return false;
        }

        visiting[course] = true;
        List<Integer> prerequisites = map.get(course);
        if (prerequisites != null) {
            for(int pre : prerequisites){
                if (!dfs(pre, map, visiting, visited, order)) {
                    return false;
                }
            }
        }

        //no pre or all pre finished
        order.add(course);
        visited[course] = true;
        return true;
    }

    private void buildMap(Map<Integer, List<Integer>> map, int [][] prerequisites) {
        for (int [] pair : prerequisites) {
            List<Integer> requires = map.get(pair[0]);
            if (requires == null) {
                requires = new ArrayList<>();
            }
            map.put(pair[0], requires);
            requires.add(pair[1]);
        }
    }
}
