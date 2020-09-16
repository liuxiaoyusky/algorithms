package RecursionIII;

import Tree.TreeNode;

/*
Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node to another leaf node. If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).

Examples

  -15

  /    \

2      11

     /    \

    6     14

The maximum path sum is 6 + 11 + 14 = 31.

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
public class MaximumPathSumBinaryTreeI {
    //clarify:leaf to leaf, assume a root with one child return Integer.MIN_VALUE, means no maximum.
    //do it by recursion
    //each node: O(1), if there are n total nodes, time:O(n), space: O(1)
    public int maxPathSum(TreeNode root) {
        int [] globalMax = new int [] {Integer.MIN_VALUE};
        //recursion function
        helper(globalMax,root);
        return globalMax[0];
    }

    //this is the recursion function
    private int helper(int [] globalMax, TreeNode root) {
        //base case
        if (root == null) {
            return 0;
        }

        //1. subproblems: find max from one left/right node to root
        int leftMax = helper(globalMax, root.left);
        int rightMax = helper(globalMax,root.right);

        //2. current level: find the max in current level, then update the globalMax if needed
        if (root.left != null && root.right != null) {
            globalMax[0] = Math.max(leftMax + rightMax + root.key, globalMax[0]);
        }


        //3. return value: return the larger value of leftMax/rightMax
        if (root.left == null) {
            return rightMax + root.key;
        }else if (root.right == null) {
            return leftMax + root.key;
        }
        return Math.max(leftMax,rightMax) + root.key;
    }
}
