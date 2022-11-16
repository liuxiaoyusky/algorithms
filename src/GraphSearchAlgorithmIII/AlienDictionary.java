package GraphSearchAlgorithmIII;

import java.util.*;

public class AlienDictionary {
    //make a tree, go through once for the whole relative location of a char
    //go through again to build the tree

    class Node {
        char value;
        int indegree;
        List<Node> nextChars;
        public Node(char value) {
            this.value = value;
            this.indegree = 0;
            nextChars = new LinkedList<>();
        }
    }

    private char [] findFirstDifferent(String a, String b) {

        int l = 0;
        int r = 0;
        char [] ans = new char[2];
        char [] aa = a.toCharArray();
        char [] bb = b.toCharArray();
        while (l < a.length() && r < b.length()) {
            if (aa[l] == bb[r]) {
                l++;
                r++;
            } else {
                ans[0] = aa[l];
                ans[1] = bb[r];
                return ans;
            }
        }
        return null;
    }

    private void findAllChars(String [] words, Map<Character, Node> map, boolean [] visited) {
        for (String s: words) {
            char [] cur = s.toCharArray();
            for (char c : cur) {
                if (map.get(c) == null) {
                    map.put(c, new Node(c));
                    visited[c - 'a'] = true;
                }
            }
        }

        for (int i = 0; i < visited.length; i++){
            visited[i] = !visited[i];
        }
    }

    public String alienOrder(String[] words) {
        Map<Character, Node> map = new HashMap<>();
        boolean [] visited = new boolean[26];
        findAllChars(words, map, visited);

        //build relations
        for(int i = 1; i < words.length; i++) {
            char [] pairs = findFirstDifferent(words[i - 1], words[i]);
            if (pairs == null) {
                continue;
            }
            Node first = map.get(pairs[0]);
            Node second = map.get(pairs[1]);

            first.nextChars.add(second);
            second.indegree++;
        }

        //topological sort
        StringBuilder sb = new StringBuilder();
        int count = map.size();
        int curCount = 0;
        while (count > 0) {
            //check cycle
            if (curCount == count) {
                return "";
            } else {
                curCount = count;
            }


            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    continue;
                }

                char curChar = (char) (i + 'a');
                Node cur = map.get(curChar);
                if (cur != null && cur.indegree == 0) {
                    sb.append(curChar);
                    visited[i] = true;
                    for (Node n : cur.nextChars) {
                        n.indegree--;
                    }
                    count--;
                }
            }
        }

        return new String(sb);
    }
}