package Tree.advanced;

import Tree.TreeNode;

/*
有可能不是bst，返回sum最大的bst
 */
public class MaxSumBST7 {
    class RT{
        int min;
        int max;
        int sum;
        boolean isBST;
        public RT(int min, int max, int sum, boolean isBST) {
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.isBST = isBST;
        }
    }

    public int findSumBST(TreeNode root) {
        int [] max = new int [] {0};
        helper(root, max);
        return max[0];
    }

    private RT helper(TreeNode root, int [] max) {
        if (root == null) {
            return new RT(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        if (root.left == null && root.right == null) {
            return new RT(root.key, root.key, root.key, true);
        }

        RT left = helper(root.left, max);
        RT right = helper(root.right, max);
        if (!left.isBST || !right.isBST) {
            return new RT(-1,-1, -1, false);
        }

        //valid
        else if (left.max < root.key && root.key < right.min) {
            return new RT(Math.min(left.min, root.key), Math.max(right.max, root.key), left.sum + right.sum + root.key, true);
        }

        else {
            return new RT(-1,-1, -1, false);
        }
    }
}
