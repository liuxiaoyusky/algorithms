package Tree.advanced;

import Tree.TreeNode;

//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
//same as Lowest Common Ancester of Deepest levels
public class SmallestSubtreeWithAllDeepestNodes12 {

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

    class RT{
        int level;
        TreeNode root;
        public RT(int l, TreeNode r){
            this.level = l;
            this.root = r;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        RT result = helper(root);
        return result.root;
    }

    private RT helper(TreeNode root) {
        if (root == null) {
            return new RT(0, null);
        }

        if (root.left == null && root.right == null) {
            return new RT(1, root);
        }

        RT left = helper(root.left);
        RT right = helper(root.right);

        if (left.level == right.level) {
            return new RT(left.level + 1, root);
        } else if (left.level < right.level) {
            return new RT(right.level + 1, right.root);
        } else {
            return new RT(left.level + 1, left.root);
        }
    }
}