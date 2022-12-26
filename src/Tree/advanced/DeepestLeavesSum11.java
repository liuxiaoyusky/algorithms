package Tree.advanced;

import Tree.TreeNode;

//https://leetcode.com/problems/deepest-leaves-sum/
public class DeepestLeavesSum11 {
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
        int height;
        int sum;
        public RT(int h, int s) {
            this.height = h;
            this.sum = s;
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        RT result = helper(root);
        return result.sum;
    }

    private RT helper(TreeNode root) {
        if (root == null) {
            return new RT(0, 0);
        }

        else if (root.left == null && root.right == null) {
            return new RT(1, root.key);
        }

        RT left = helper(root.left);
        RT right = helper(root.right);

        if (left.height == right.height) {
            return new RT(left.height + 1, left.sum + right.sum);
        } else if (left.height < right.height) {
            return new RT(right.height + 1, right.sum);
        } else {
            return new RT(left.height + 1, left.sum);
        }
    }
}