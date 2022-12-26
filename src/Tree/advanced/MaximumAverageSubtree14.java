package Tree.advanced;

import Tree.TreeNode;

//https://leetcode.com/discuss/interview-question/349617
public class MaximumAverageSubtree14 {
    class RT {
        int count;
        int sum;
        public RT(int c, int s) {
            this.count = c;
            this.sum = s;
        }
    }

    public double findMax(TreeNode root) {
        double [] max = new double[] {0};
        helper(root, max);
        return max[0];
    }

    private RT helper(TreeNode root, double [] max) {
        if (root == null) {
            return new RT(0,0);
        }

        if (root.right == null && root.left == null) {
            max[0] = Math.max(max[0], root.key / 1.0);
            return new RT (1, root.key);

        }

        RT left = helper(root.left, max);
        RT right = helper(root.right, max);

        int curCount = left.count + right.count + 1;
        int curSum = left.sum + right.sum + root.key;
        max[0] = Math.max(max[0], 1d * curSum/curCount);
        return new RT(curCount, curSum);
    }
}
