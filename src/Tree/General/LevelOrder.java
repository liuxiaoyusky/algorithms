package Tree.General;

import Tree.TreeNode;

import java.util.*;

//https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/875158280/
public class LevelOrder {


    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            result.add(list);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.key);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        return result;
    }
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }


    private void helper(TreeNode root, int index, List<List<Integer>> answer) {
        if (root == null) {
            return;
        }
        List<Integer> list = null;
        if (answer.size() > index) {
            list = answer.get(index);
        } else {
            list = new ArrayList<Integer>();
            answer.add(list);
        }

        list.add(root.key);
        helper(root.left, index + 1, answer);
        helper(root.right, index + 1, answer);
    }
}