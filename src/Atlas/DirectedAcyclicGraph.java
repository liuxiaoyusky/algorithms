package Atlas;

import java.util.*;

public class DirectedAcyclicGraph {
    //might be able to optimized by Dijkstra, now for simplified used for loop to go through all possible
    //use a map to keep track the shortest way between all nodes
    //making the map in breath first search
    public Map<DirectedAcyclicGraphNode, Integer> shortestDistance(DirectedAcyclicGraphNode start) {
        Map<DirectedAcyclicGraphNode, Integer> map = new HashMap<>();
        map.put(start,0);
        helper(start, map);
        return map;
    }
    //recursively update the shortest distance between target to all reachable node
    //since acyclic, doesn't have a loop and forever run
    private void helper(DirectedAcyclicGraphNode cur, Map<DirectedAcyclicGraphNode, Integer> map) {
        Map<DirectedAcyclicGraphNode, Integer> edges = cur.edges;
        //for each vertEx, if we have a distance before, compare it to new dis = dis to cur + cur to vertex
        for (DirectedAcyclicGraphNode vertex : edges.keySet()) {
            Integer oldDis = map.get(vertex);
            Integer newDis = edges.get(vertex) + map.get(cur);
            //update
            if (oldDis == null || newDis < oldDis) {
                map.put(vertex, newDis);
            }
        }

        //keep updating from next node
        for(DirectedAcyclicGraphNode vertex : edges.keySet()) {
            helper(vertex,map);
        }
    }
}
