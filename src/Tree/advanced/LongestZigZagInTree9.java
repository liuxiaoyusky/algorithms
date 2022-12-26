package Tree.advanced;

import Tree.TreeNode;

/*
You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

    Choose any node in the binary tree and a direction (right or left).
    If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
    Change the direction from right to left or from left to right.
    Repeat the second and third steps until you can't move in the tree.

Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.
 */
public class LongestZigZagInTree9 {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    class RT {
        int fromLeftHeight;
        int fromRightHeight;
        public RT(int l, int r) {
            this.fromLeftHeight= l;
            this.fromRightHeight = r;
        }
    }
    //at root, we make it level 0
    public int longestZigZag(TreeNode root) {
        int [] max = new int [] {0};
        helper(root, max);
        return max[0];
    }

    private RT helper(TreeNode root, int [] max) {
        if (root == null) {
            return new RT(-1, -1);
        }

        RT left = helper(root.left, max);
        RT right = helper(root.right, max);
        int fromLeft = left.fromRightHeight + 1;
        int fromRight = right.fromLeftHeight + 1;
        int curMax = Math.max(fromLeft, fromRight);
        max[0] = Math.max(max[0], curMax);

        return new RT(fromLeft, fromRight);
    }
}