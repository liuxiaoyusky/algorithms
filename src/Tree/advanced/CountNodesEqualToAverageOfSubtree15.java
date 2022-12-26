package Tree.advanced;

import Tree.TreeNode;

public class CountNodesEqualToAverageOfSubtree15 {
    class RT{
        int sum;
        int counts;
        public RT(int s, int c) {
            this.sum = s;
            this.counts = c;
        }
    }

    public int counts(TreeNode root) {
        int [] counts = new int [] {0};
        helper(root, counts);
        return counts[0];
    }

    private RT helper(TreeNode root, int [] counts) {
        if (root == null) {
            return new RT(0,0);
        }

//        if (root.left == null && root.right == null) {
//            if (root.key == 0) {
//                counts[0]++;
//            }
//        }

        RT left = helper(root.left, counts);
        RT right = helper(root.right, counts);

        int sum = root.key + left.sum + right.sum;
        int size = 1 + left.counts + right.counts;
        if (root.key == sum/size) {
            counts[0]++;
        }

        return new RT(sum, size);
    }
}
