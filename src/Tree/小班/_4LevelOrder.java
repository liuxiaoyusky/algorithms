package Tree.小班;

import Tree.TreeNode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _4LevelOrder {
    //dfs
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<>();
        dfs(root, 0, ans);
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        List<Integer> list = null;
        if (level >= ans.size()) {
            list = new LinkedList<>();
            ans.add(list);
        }
        list = ans.get(level);
        list.add(root.key);

        dfs(root.left, level + 1, ans);
        dfs(root.right, level + 1, ans);
    }

    //bfs
    public List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ls = new LinkedList<>();
            ans.add(ls);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                ls.add(cur.key);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}