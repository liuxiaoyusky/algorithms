package Graph.小班.TopologicalII;

import java.util.*;

public class _1DetermineIfOnlyOneValidTopologicalOrder {
   /*
   input: Map<Integer, List<Integer>>
   Vertex: key
   Edges: value
   weight: uni

   what problem?
   topological sort

   what traversal?
   iterative/bfs/dfs with indegree

    let's do it bfs
    Time:O(V + E)
    Space: O(V)
    */

    public static boolean findOrder(Map<Integer, List<Integer>> map) {
        //sanity check
        if (map == null || map.size() == 0) {
            return true;
        }

        //build map
        Map<Integer, Node> graph = buildGraph(map);

        //find all indegree == 0
        Queue<Node> queue = find0Indegree(graph);

        int count = 0;
        while(!queue.isEmpty()) {
            //base case
            if (queue.size() != 1) {
                return false;
            }
            Node cur = queue.poll();
            count++;

            for (Node nei : cur.neighbor) {
                nei.indegree--;
                if (nei.indegree == 0) {
                    queue.offer(nei);
                }
            }
        }

        //check if all nodes are visited, if all visited, return ture, else, we have cycle and return false
        return count == graph.size();
    }

    private static Queue<Node> find0Indegree(Map<Integer, Node> map) {
        Queue<Node> ans = new LinkedList<>();
        for (Node n : map.values()){
            if (n.indegree == 0) {
                ans.offer(n);
            }
        }

        return ans;
    }

    private static Map<Integer, Node> buildGraph(Map<Integer, List<Integer>> map) {
        Map<Integer,Node> graph = new HashMap<>();
        for (Integer cur : map.keySet()) {
            Node curNode = graph.get(cur);
            if (curNode == null) {
                curNode = new Node(cur);
                graph.put(cur, curNode);
            }

            //clone neighbor
            for (Integer nei : map.get(cur)){
                Node neiNode = graph.get(cur);
                if (neiNode == null) {
                    neiNode = new Node(nei);
                    graph.put(nei,neiNode);
                }

                curNode.neighbor.add(neiNode);
                neiNode.indegree++;
            }
        }

        return graph;
    }

    static class Node{
        int key;
        List<Node> neighbor;
        int indegree;
        public Node(int k) {
            key = k;
            neighbor = new ArrayList<>();
            indegree = 0;
        }

        @Override
        public int hashCode() {
            return key;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (!(o instanceof Node)){
                return false;
            }

            Node oo = (Node) o;
            return this.key == oo.key;
        }
    }

}
