package Tree.advanced;

import Tree.TreeNode;

/*
Determine if a given binary tree is full.

A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. Conversely, there is no node in a full binary tree, which has one child node.

If the root is null, return false.
 */
public class IsFullTree2 {
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
    public boolean isFull(TreeNode root) {
        //corner case
        if (root == null) {
            return false;
        }

        boolean left = isFull(root.left);
        boolean right = isFull(root.right);

        if (root.left == null && root.right == null) {
            return true;
        }

        else if (root.left != null && root.right != null && left && right) {
            return true;
        }

        return false;
    }
}
