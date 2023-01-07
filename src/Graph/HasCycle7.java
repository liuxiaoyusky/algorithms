package Graph;

import java.util.ArrayList;
import java.util.List;

public class HasCycle7 {

    enum State{
        UNVISITED, VISITING, VISITED;
    }
    class Vertex{
        State curState;
        int value;
        List<Vertex> neighbors;
        public Vertex(int v) {
            this.value = v;
            this.curState = State.UNVISITED;
            this.neighbors = new ArrayList<>();
        }
    }
    public boolean hasCycle(List<Vertex> graph) {
        for (Vertex v : graph) {
            if (hasCycleUNI(v)) {
                return true;
            }
        }
        return false;
    }

    //one way
    private boolean hasCycleUNI(Vertex v) {
        if (v.curState == State.VISITING) {
            return true;
        }

        if (v.curState == State.VISITED) {
            return false;
        }

        v.curState = State.VISITING;
        for (Vertex n : v.neighbors) {
            if (hasCycleUNI(n)) {
                return true;
            }
        }
        return false;
    }

    //two ways
    private boolean hasCycleBI(Vertex cur, Vertex prev) {
        if (cur.curState == State.VISITED) {
            return true;//has cycle
        }
        cur.curState = State.VISITED;
        for (Vertex n : cur.neighbors) {
            if (n != prev && hasCycleBI(n, cur)) {
                return true;
            }
        }
        return false;
    }
}
