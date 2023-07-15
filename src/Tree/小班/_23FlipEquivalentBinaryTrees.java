package Tree.小班;

import Tree.TreeNode;

//https://leetcode.com/problems/flip-equivalent-binary-trees/submissions/890960165/
public class _23FlipEquivalentBinaryTrees {
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
    //at each node, check if same order or reverse order; if both not true, return false
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //base case
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }

        //both not null, compare same root value
        if (root1.val != root2.val) {
            return false;
        }

        //compare child
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}