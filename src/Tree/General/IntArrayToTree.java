package Tree.General;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class IntArrayToTree {
    public TreeNode toTree(Integer [] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (node.left == null) {
                node.left = new TreeNode(array[i]);
                if (array[i] != null) {
                    queue.offer(node.left);
                }
            }
            else if (node.right == null) {
                node.right = new TreeNode(array[i]);
                if (array[i] != null) {
                    queue.offer(node.right);
                }
                queue.poll();
            }
        }

        return root;
    }

    public void printTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int size = queue.size();
        while (!queue.isEmpty()) {
            int newSize = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null || cur.key == null) {
                    System.out.print("null ");
                } else {
                    System.out.print(cur.key + " ");
                    if (cur.left != null) {
                        queue.offer(cur.left);
                        newSize++;
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                        newSize++;
                    }
                }
            }

            size = newSize;
            System.out.println();
        }
    }
}
