package Tree.小班;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/n-ary-tree-postorder-traversal/
public class _7NaryPostOrder {
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
    //dfs
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }


        for (Node nei : root.children) {
            dfs(nei, ans);
        }

        ans.add(root.val);
    }
}
