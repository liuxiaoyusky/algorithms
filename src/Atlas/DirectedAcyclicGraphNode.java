package Atlas;

import java.util.HashMap;
import java.util.Map;

/*
Given such graph: weights of the edges = distances between two vertices
#1: define data structure
#2: given vertex, calculate the shortest distance from v to the other vertices of G
 */
public class DirectedAcyclicGraphNode {
    public Map<DirectedAcyclicGraphNode,Integer> edges;
//    private String name;

    //constructor
    public DirectedAcyclicGraphNode() {
//        this.name = name;
        this.edges = new HashMap<>();
    }

    public void addNeighbors(DirectedAcyclicGraphNode neighbor, int weight) {
        if (!edges.containsKey(neighbor)) {
            edges.put(neighbor,weight);
        }
    }

}
