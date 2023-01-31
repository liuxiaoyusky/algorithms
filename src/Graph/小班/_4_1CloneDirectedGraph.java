package Graph.小班;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _4_1CloneDirectedGraph {
    //not connected
    class Vertex{
        int value;
        List<Vertex> nei;
        public Vertex (int v) {
            this.value = v;
            nei = new ArrayList<>();
        }
    }

    public List<Vertex> clone(List<Vertex> graph) {
        //sanity check
        if (graph == null || graph.isEmpty()) {
            return null;
        }

        Map<Vertex, Vertex> map = new HashMap<>();
        for (Vertex v : graph) {
            dfs(v, map);
        }

        List<Vertex> vertices = new ArrayList<>(map.values());
        return vertices;
    }

    private void dfs(Vertex v, Map<Vertex, Vertex> map) {
        if (map.get(v) != null) {
            return;
        }

        //clone vertex
        Vertex newV = new Vertex(v.value);
        //mark visited
        map.put(v, newV);

        //clone neighbor
        for (Vertex neig : v.nei) {
            //do the clone first
            dfs(neig, map);
            Vertex newNeig = map.get(neig);
            newV.nei.add(newNeig);
        }
    }
}
