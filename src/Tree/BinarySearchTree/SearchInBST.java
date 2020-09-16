package Tree.BinarySearchTree;

import Tree.TreeNode;


/*
Find the target key K in the given binary search tree, return the node that contains the key if K is found, otherwise return null.
Assumptions
There are no duplicate keys in the binary search tree
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

//time: O(logn) space:O(1)
public class SearchInBST {
    public TreeNode search(TreeNode root, int key) {
        //assume root == null return null
        //assume left <root<right, no duplicate
        if(root==null){
            return null;
        }
        while(root!=null){
            if(root.key==key){
                return root;
            }else if(root.key<key){
                root=root.right;
            }else{
                root=root.left;
            }
        }
        //not found, return null
        return null;
    }
}
