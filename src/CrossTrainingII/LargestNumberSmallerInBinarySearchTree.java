package CrossTrainingII;

import Tree.TreeNode;
/*
In a binary search tree, find the node containing the largest number smaller than the given target number.

If there is no such number, return -2^31.

Assumptions:

    The given root is not null.
    There are no duplicate keys in the binary search tree.

Examples

    5

  /    \

2      11

     /    \

    6     14

largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)

largest number smaller than 10 is 6

largest number smaller than 6 is 5

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
public class LargestNumberSmallerInBinarySearchTree {
    //left < node < right
    //find the right most node that is smaller than target
    //for each level, if node < target, update date cur value with node.value and go right; else, go left
    public int largestSmaller(TreeNode root, int target) {
        int cur = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key < target) {
                cur = root.key;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return cur;
    }
}
