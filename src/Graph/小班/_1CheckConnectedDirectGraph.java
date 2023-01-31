package Graph.小班;

import java.util.ArrayList;
import java.util.List;

public class _1CheckConnectedDirectGraph {
    //for a given graph, check if there is a path between any pair of vertexs

    public boolean isConnected(List<List<Integer>> graph) {
        if (graph == null) {
            return true;
        }
        if (!checkConnectness(graph)) {
            return false;
        }
        if (checkConnectness(reverse(graph))) {
            return  true;
        } else {
            return false;
        }
    }
    private boolean checkConnectness(List<List<Integer>> graph) {
        boolean [] visited = new boolean[graph.size()];
        int [] count = {0};
        findAllConnected(0, graph, count, visited);
        return count[0] == graph.size();
    }

    private void findAllConnected(int key, List<List<Integer>> graph, int [] count, boolean [] visited) {
        if (visited[key]) {
            return;
        }

        visited[key] = true;
        count[0]++;

        for (int nei : graph.get(key)) {
            findAllConnected(nei, graph, count, visited);
        }
    }

    private List<List<Integer>> reverse(List<List<Integer>> graph) {
        List<List<Integer>> newGraph = new ArrayList<>(graph.size());
        for (int i = 0; i < graph.size(); i++) {
            newGraph.add(new ArrayList<>());
        }
        boolean [] copied = new boolean[graph.size()];
        copy(0, graph, newGraph, copied);
        return newGraph;
    }

    private void copy(int key, List<List<Integer>> graph, List<List<Integer>> newGraph, boolean [] copied) {
        if (copied[key]) {
            return;
        }

        copied[key] = true;


        for (int nei : graph.get(key)) {
            copy(nei, graph, newGraph, copied);
            newGraph.get(nei).add(key);
        }
    }
}
