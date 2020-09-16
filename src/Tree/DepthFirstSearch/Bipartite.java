package Tree.DepthFirstSearch;

import Tree.GraphNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two groups
 such that no nodes have direct edges to other nodes in the same group.
Examples
1  --   2
    /
3  --   4
is bipartite (1, 3 in group 1 and 2, 4 in group 2).
1  --   2
    /   |
3  --   4
is not bipartite.
Assumptions
The graph is represented by a list of nodes, and the list of nodes is not null.
 */
public class Bipartite {
    public boolean checkBipartite(List<GraphNode> graph){
        HashMap <GraphNode,Integer> visited=new HashMap<>();
        for(GraphNode node:graph){
            if(!bfs(node,visited)){
                return false;
            }
        }
        return true;
    }

    private boolean bfs(GraphNode node,HashMap<GraphNode,Integer> visited){
        if(visited.containsKey(node)){
            return true;
        }

        Deque <GraphNode> queue=new LinkedList<>();
        queue.offerLast(node);
        visited.put(node,0);
        while(!queue.isEmpty()){
            GraphNode cur=queue.pollFirst();
            int nei= visited.get(cur)==0 ? 1:0;
            for(GraphNode neiNode: cur.neighbors){
                Integer temp=visited.get(neiNode);
                //not been visited
                if(temp==null){
                    visited.put(neiNode,nei);
                    queue.offerLast(neiNode);
                }else{
                    //visited and has same value with nei
                    if(temp!=nei){
                        return false;
                    }else{
                        continue;
                    }
                }
            }
        }

        //finish bfs this node
        return true;
    }
}
