package Tree.advanced;

import Tree.TreeNode;

/*
Check if a given binary tree is balanced. A balanced binary tree is one in which the depths of every node’s left and right subtree differ by at most 1.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

is balanced binary tree,

        5

      /

    3

  /   \

1      4

is not balanced binary tree.

Corner Cases

    What if the binary tree is null? Return true in this case.

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
 */
public class CheckIfBinaryTreeIsBalanced1 {
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
    private static final int FALSE = -1;
    public boolean isBalanced(TreeNode root) {
        //base case
        if (root == null) {
            return true;
        }

        return helper(root) != FALSE;
    }

    //-1 = false, >=0 is height and true
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        if (left == FALSE || right == FALSE) {
            return FALSE;
        }

        //compare height
        if (Math.abs(left - right) < 2) {
            return Math.max(left, right) + 1;
        }
        return FALSE;
    }
}
