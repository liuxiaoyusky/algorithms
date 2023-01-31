package Tree.小班;

import java.util.*;

//https://leetcode.com/problems/clone-n-ary-tree/
public class _9CloneNaryTree {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    //dfs
    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }

        Node newRoot = new Node(root.val);
        for (Node nei : root.children) {
            newRoot.children.add(cloneTree(nei));
        }

        return newRoot;
    }

    //iterative
    public Node cloneTreeIter(Node root) {
        if (root == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node newRoot = new Node(root.val);
        map.put(root,newRoot);

        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Node newCur = map.get(cur);
            for(Node nei : cur.children) {
                Node newNei = new Node(nei.val);
                map.put(nei, newNei);
                newCur.children.add(newNei);
                queue.offer(nei);
            }
        }

        return newRoot;
    }
}
