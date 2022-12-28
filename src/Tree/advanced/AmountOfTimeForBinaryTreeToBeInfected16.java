package Tree.advanced;

import Tree.TreeNode;

public class AmountOfTimeForBinaryTreeToBeInfected16 {
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
    class ReturnType {
        boolean found;
        int distanceToStartOrHeight;
        public ReturnType (boolean found, int distanceToStartOrHeight) {
            this.found = found;
            this.distanceToStartOrHeight = distanceToStartOrHeight;
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        int [] max = new int [] {0};
        helper(root, start, max);
        return max[0];
    }

    private ReturnType helper(TreeNode root, int start, int [] max) {
        if (root == null) {
            return new ReturnType(false, 0);
        }

        ReturnType left = helper(root.left, start, max);
        ReturnType right = helper(root.right, start, max);

        //general case
        //case 1: on the point
        if (root.key == start) {
            max[0] = Math.max(left.distanceToStartOrHeight, right.distanceToStartOrHeight);
            return new ReturnType(true, 0);
        }

        //case 2: both not found, return true height
        if (!left.found && !right.found) {
            return new ReturnType(false, Math.max(left.distanceToStartOrHeight, right.distanceToStartOrHeight) + 1);
        }

        //case 3: found infection on one side, try update max, return the height of infection
        max[0] = Math.max(max[0], left.distanceToStartOrHeight + right.distanceToStartOrHeight + 1);
        int returnValue = left.found ? left.distanceToStartOrHeight + 1 : right.distanceToStartOrHeight + 1;
        return new ReturnType(true, returnValue);
    }
}