package Tree.advanced;

import Tree.TreeNode;

/*
467. Largest BST Subtree
Medium

Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:

    10
    / \
   5  15
  / \   \
 1   8   7

The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3. 

Follow up:
Can you figure out ways to solve it with O(n) time complexity?
 */
public class LargestBSTSubTree5 {
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

    class ReturnType {
        int size;
        int min;
        int max;
        boolean isTree;
        public ReturnType (int size, int min, int max, boolean isTree) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isTree = isTree;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int [] largestSize = new int [] {0};
        helper(root, largestSize);
        return largestSize[0];
    }

    private ReturnType helper(TreeNode root, int [] largestSize) {
        //base case
        if (root == null) {
            return new ReturnType(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        //case 1, both child null
        if (root.left == null && root.right == null) {
            largestSize[0] = Math.max(largestSize[0], 1);
            return new ReturnType(1, root.key, root.key, true);
        }

        ReturnType left = helper(root.left, largestSize);
        ReturnType right = helper(root.right, largestSize);

        //if either of them is not tree, stop updating largest from now on
        if (!left.isTree || !right.isTree) {
            return new ReturnType(-1, 0, 0, false);
        }

        //check if current is a tree, left < root < right
        if (left.max < root.key && root.key < right.min) {
            int min = Math.min(left.min, root.key);
            int max = Math.max(right.max, root.key);
            int size = left.size + right.size + 1;
            largestSize[0] = Math.max(largestSize[0], size);
            return new ReturnType(size, min, max, true);
        }

        return new ReturnType(-1, 0, 0, false);
    }
}

