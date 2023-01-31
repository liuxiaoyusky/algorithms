package Tree.小班;

import Tree.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class _13LCA1 {
    //dfs:one child find: return the child;
    //both child find, return root;
    //no child found, return null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }


    }
}
