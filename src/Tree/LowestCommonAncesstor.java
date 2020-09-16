package Tree;

import Tree.TreeNode;
/*
Given two keys in a binary search tree, find their lowest common ancestor.
Assumptions
There is no parent pointer for the nodes in the binary search tree
There are no duplicate keys in the binary search tree
The given two nodes are guaranteed to be in the binary search tree
Examples
        5
      /   \
     2     12
   /  \      \
  1    3      14
The lowest common ancestor of 1 and 14 is 5
The lowest common ancestor of 1 and 3 is 2
 */

// time: O(n) space: O(1)
public class LowestCommonAncesstor {
    public TreeNode lca(TreeNode root, int p, int q) {
        // assume no duplicate, two nodes are guaranteed to be in the binary search tree
        //find the kid nodes, return it self
        if(root == null||root.key == p || root.key == q){
            return root;
        }

        // if left and right are both null, return null
        // if one of left or right is not null, return it, it is either a child, or the lca, pass it to the higher level
        // if both left and right are not null, return the root, which is the answer
        TreeNode left = lca(root.left, p,q);
        TreeNode right = lca(root.right, p,q);

        if(left!=null && right!=null){
            return root;
        }else{
            return left==null? right : left;
        }
    }
}
