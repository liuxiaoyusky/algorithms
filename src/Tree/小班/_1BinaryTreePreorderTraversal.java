package Tree.小班;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _1BinaryTreePreorderTraversal {

    //dfs
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.key);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }

    //iterative
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            ans.add(cur.key);

            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }

            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }

        }

        return ans;
    }
}