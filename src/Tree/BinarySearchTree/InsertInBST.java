package Tree.BinarySearchTree;


import Tree.TreeNode;
/*
Insert a key in a binary search tree if the binary search tree does not already contain the key. Return the root of the binary search tree.
Assumptions
There are no duplicate keys in the binary search tree
If the key is already existed in the binary search tree, you do not need to do anything
Examples
        5
      /    \
    3        8
  /   \
 1     4
insert 11, the tree becomes
        5
      /    \
    3        8
  /   \        \
 1     4       11
insert 6, the tree becomes
        5
      /    \
    3        8
  /   \     /  \
 1     4   6    11
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

//time: O(logn) Space:O(1)
public class InsertInBST {
    public TreeNode insert(TreeNode root, int key) {
        //assmue no duplicate, do nothing if exists
        //if null, take it as root
        //take root, return root
        if(root==null){
            TreeNode newRoot = new TreeNode(key);
            return newRoot;
        }

        TreeNode cur = root;
        TreeNode prev = root;
        TreeNode newNode = new TreeNode(key);
        //find the place to insert
        while(cur!=null){
            if(cur.key==key){
                return root;
            }else if(cur.key<key){
                prev=cur;
                cur=cur.right;
            }else{
                prev = cur;
                cur=cur.left;
            }
        }

        //add it in
        if(prev.key<key){
            prev.right = newNode;
        }else{
            prev.left = newNode;
        }
        return root;
    }
}
