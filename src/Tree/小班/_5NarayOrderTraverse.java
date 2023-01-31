package Tree.小班;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/n-ary-tree-level-order-traversal/
public class _5NarayOrderTraverse {
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(Node root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (ans.size() <= level) {
            ans.add(new LinkedList<>());
        }

        ans.get(level).add(root.val);

        for (Node nei : root.children) {
            dfs(nei, level + 1, ans);
        }
    }

    //iterative
    //-------------------------------------------
    //iterative
    public List<List<Integer>> levelOrderIterative(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ls = new LinkedList<>();
            ans.add(ls);
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                ls.add(cur.val);

                for (Node nei : cur.children) {
                    queue.offer(nei);
                }
            }
        }
        return ans;
    }
}
