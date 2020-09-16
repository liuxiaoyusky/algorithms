package Tree;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int key;
    public List<GraphNode> neighbors=new ArrayList<GraphNode>();
    public GraphNode(int value){
        key=value;
    }
}
