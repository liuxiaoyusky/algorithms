package Tree.advanced;

import Tree.TreeNode;

/*
Determine if a given binary tree is binary search tree.There should no be duplicate keys in binary search tree.

Assumptions

    You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.

Corner Cases

    What if the binary tree is null? Return true in this case.
 */
public class isBST4{
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
    class RT {
        int max;
        int min;
        public RT (int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
    public boolean isBST(TreeNode root) {
        boolean [] res = new boolean [] {true};
        helper(root, res);
        return res[0];
    }

    private RT helper(TreeNode root, boolean [] res) {
        //reverse bound
        if (root == null) {
            return new RT(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        if (root.left == null && root.right == null) {
            return new RT(root.key, root.key);
        }

        RT left = helper(root.left, res);
        RT right = helper(root.right, res);

        if (!res[0]) {
            return new RT(0, 0);
        }

        //not a bst
        if (root.key >= right.min || root.key <= left.max) {
            res[0] = false;
            return new RT(0, 0);
        }

        int minValue = Math.min(root.key, left.min);
        int maxValue = Math.max(root.key, right.max);
        return new RT(maxValue, minValue);
    }
}

