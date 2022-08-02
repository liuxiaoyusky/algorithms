package BinarySearch;

/*
52. Search In Binary Search Tree
Easy
Find the target key K in the given binary search tree, return the node that contains the key if K is found, otherwise return null.

Assumptions

There are no duplicate keys in the binary search tree
 */


   class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
  }

public class SearchInBinaryTree {
    public TreeNode search(TreeNode root, int key) {
        //corner case
        if (root == null) {
            return null;
        }

        //for each root, if target < root.key, go left, else go right
        TreeNode cur = root;
        while (cur != null) {
            if (cur.key == key) {
                return cur;
            } else if (cur.key < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        //if end, then no root has this value
        return null;
    }
}
