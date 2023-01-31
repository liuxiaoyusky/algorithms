package Tree.小班;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/n-ary-tree-preorder-traversal/
public class _6NaryPreOrder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    //iterative
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Deque<Node> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pollFirst();
            ans.add(cur.val);

            for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.offerFirst(cur.children.get(i));
            }
        }

        return ans;
    }
}
