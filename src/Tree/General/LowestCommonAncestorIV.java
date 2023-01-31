package Tree.General;

import Tree.TreeNode;

import java.util.List;
/*
Given K nodes in a binary tree, find their lowest common ancestor.
Assumptions
K >= 2
There is no parent pointer for the nodes in the binary tree
The given K nodes are guaranteed to be in the binary tree
Examples
        5
      /   \
     9     12
   /  \      \
  2    3      14
The lowest common ancestor of 2, 3, 14 is 5
The lowest common ancestor of 2, 3, 9 is 9
 */

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
public class LowestCommonAncestorIV {
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        // k nodes, guaranteed to be in the binary tree
        // do it recursively, we can still return when we find one the the nodes since the rest of unseen nodes must be
        //descendants of the returned nodes

        if(root == null){
            return null;
        }

        //find the location of node in nodes list, or return the lca to the top
        for(TreeNode cur: nodes){
            if(root.key == cur.key){
                return root;
            }
        }

        //think about left and right
        TreeNode left = lowestCommonAncestor(root.left,nodes);
        TreeNode right = lowestCommonAncestor(root.right,nodes);

        if(left!=null && right!=null){
            return root;
        } else if(left == null){
            return right;
        }else{
            return left;
        }
    }
}