package Tree.小班;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/clone-binary-tree-with-random-pointer/
public class _8CloneBTWithRandom {
     public class Node {
        int val;
        Node left;
        Node right;
        Node random;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right, Node random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    public class NodeCopy {
        int val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;
        NodeCopy() {}
        NodeCopy(int val) { this.val = val; }
        NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }
    //Use a map to keep track of copied nodes
    //do it in dfs
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> map = new HashMap<>();
        return helper(root, map);
    }

    private NodeCopy helper(Node root, Map<Node, NodeCopy> map) {
        if (root == null) {
            return null;
        }
        NodeCopy copyCur = map.get(root);
        if (map.get(root) != null) {
            return copyCur;
        }

        copyCur = new NodeCopy(root.val);
        map.put(root, copyCur);

        if (copyCur.left == null) {
            copyCur.left = helper(root.left, map);
        }
        if (copyCur.right == null) {
            copyCur.right = helper(root.right, map);
        }
        if (copyCur.random == null) {
            copyCur.random = helper(root.random, map);
        }
        return copyCur;
    }
}
