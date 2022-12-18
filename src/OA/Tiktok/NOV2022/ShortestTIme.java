package OA.Tiktok.NOV2022;

import java.util.*;

public class ShortestTIme {
    //dikastra

    static class Node {
        String name;
        Map<Node, Integer> edges;
        long curShortest;


        public Node (String name) {
            this.name = name;
            edges = new HashMap<>();
            curShortest = Integer.MAX_VALUE;
        }
    }

    public static long getShortest(String [][] input) {

        HashMap<String, Node> map = new HashMap<>();//all nodes list(string to node)
        Set<Node> shortestPast = new HashSet<>();

        //String input to nodes
        for (int i = 0; i < input.length; i++) {
            String [] cur  = input[i];
            String start = cur[0];
            String end = cur[1];
            int cost = Integer.parseInt(cur[2]);

            Node startNode = map.get(start);
            Node endNode = map.get(end);
            if (startNode == null) {
                startNode = new Node(start);
                map.put(start, startNode);
            }
            if (endNode == null) {
                endNode = new Node(end);
                map.put(end, endNode);
            }

            startNode.edges.put(endNode, cost);
        }

        //dikastra
        Set <Node> visitingList = new HashSet<>();
        visitingList.add(map.get("home"));
        map.get("home").curShortest = 0;


        while (!visitingList.isEmpty()) {
            Node cur = getShortest(visitingList);
            if (cur.name == "office"){
                return cur.curShortest;
            }
            visitingList.remove(cur);
            shortestPast.add(cur);

            Map<Node, Integer> edges = cur.edges;
            for(Map.Entry<Node, Integer> e: edges.entrySet()){
                Node n = e.getKey();
                //already get the shortest
                if (shortestPast.contains(n)){
                    continue;
                }

                visitingList.add(n);
                Integer i = e.getValue();
                if (cur.curShortest + i < n.curShortest){
                    n.curShortest = cur.curShortest + i;
                }
            }
        }

        if (shortestPast.contains(map.get("office"))){
            return map.get("office").curShortest;
        }
        return -1;
    }

    private static Node getShortest(Set<Node> list) {
        long shortest = Long.MAX_VALUE;
        Node cur = null;
        for (Node n : list) {
            if (n.curShortest < shortest){
                cur = n;
                shortest = n.curShortest;
            }
        }

        return cur;
    }
}
