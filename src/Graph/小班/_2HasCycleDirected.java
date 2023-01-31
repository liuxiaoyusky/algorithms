package Graph.小班;

import java.util.List;

public class _2HasCycleDirected {
    enum State{
        UNVISITED, VISITING, VISITED;
    }

    class Vertex{
        List<Vertex> neighbor;
        State state = State.UNVISITED;
    }

    //--------------------solution 3: topological------------------------------------------------------------

    //----------------------------------------dfs 3, all path----------------------------------------
    public boolean hasCycleII(List<Vertex> graph) {
        for (Vertex v : graph) {
            if (helper(v)) {
                return true;
            }
        }

        return false;
    }

    private boolean helper(Vertex v) {
        if (v.state == State.VISITED) {
            return true;
        }
        v.state = State.VISITED;
        for (Vertex nei : v.neighbor) {
            if (helper(nei)) {
                return true;
            }
        }
        v.state = State.UNVISITED;
        return false;
    }

    //----------------------------------------dfs 2----------------------------------------
    public boolean hasCycle(List<Vertex> graph) {
        for (Vertex v : graph) {
            if (hasCycle(v)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Vertex v) {
        if (v.state == State.VISITED) {
            return false;
        }

        if (v.state == State.VISITING) {
            return true;
        }

        v.state = State.VISITING;
        for (Vertex nei : v.neighbor) {
            if (hasCycle(nei)) {
                return true;
            }
        }
        v.state = State.VISITED;
        return false;
    }
}
