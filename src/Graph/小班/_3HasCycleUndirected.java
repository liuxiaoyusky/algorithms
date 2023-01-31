package Graph.小班;

import java.util.List;

public class _3HasCycleUndirected {
    enum State{
        UNVISITED, VISITED;
    }

    class Vertex{
        List<Vertex> neighbor;
       State state = State.UNVISITED;
    }

    //assume all connected
    public boolean hasCycle(List<Vertex> graph) {
        for (Vertex v : graph) {
            if (hasCycle(null, v)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Vertex prev, Vertex cur) {
        if (cur.state == State.VISITED) {
            if (prev == null) {
                return false;
            }
            else {
                return true;
            }
        }
        cur.state = State.VISITED;
        for (Vertex nei : cur.neighbor) {
            if (nei != prev && hasCycle(cur, nei)) {
                return true;
            }
        }
        return false;

    }
}
