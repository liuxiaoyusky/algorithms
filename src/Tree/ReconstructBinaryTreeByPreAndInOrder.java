package Tree;

import java.util.HashMap;

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

/*
Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
Assumptions
The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree
Examples
preorder traversal = {5, 3, 1, 4, 8, 11}
inorder traversal = {1, 3, 4, 5, 8, 11}
the corresponding binary tree is
        5
      /    \
    3        8
  /   \        \
1      4        11
How is the binary tree represented?
We use the pre order traversal sequence with a special symbol "#" denoting the null node.
For Example:
The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:
    1
  /   \
 2     3
      /
    4
 */

public class ReconstructBinaryTreeByPreAndInOrder {
//solution two: traverse both sequences at same time
//time: O(n) Space O(1)
    public TreeNode reconstructII(int[] inOrder, int[] preOrder) {
        //assume given sequences arenot null and same length
        int [] inIndex = new int [] {0};
        int [] preIndex = new int [] {0};
        return helperII(inOrder,preOrder,inIndex,preIndex,Integer.MAX_VALUE);
    }

    private TreeNode helperII(int [] in, int [] pre, int [] inIndex, int [] preIndex, int target){
        //pre: root left right
        //in: left root right
        //traverse in and pre the same time; target is the key of root,not necessarily left<root<right
        //we use target to identify the boundary of left subtree
        if(inIndex[0]>=in.length||in[inIndex[0]]==target){
            return null;
        }

        TreeNode root = new TreeNode(pre[preIndex[0]]);
        //preIndex advence one since we finished the root
        preIndex[0]++;
        root.left = helperII(in,pre,inIndex,preIndex,root.key);
        //inIndex advence one since we finished left subtree
        inIndex[0]++;
        root.right = helperII(in,pre,inIndex,preIndex,target);
        return root;
    }

//Time O(n) Space O(n)
//solution 1, recursively. Utilizing the inOrder sequence to determine the size of left/right subtrees
//preleft is the index of new root on left subtree, preright determines where the left subtree ends so we can seek the
// root of right subtree
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        //assume given sequences arenot null and same length
        HashMap<Integer,Integer> inOrderMap = inMap(inOrder);
        return helper(inOrderMap,0,inOrder.length-1,preOrder,0, preOrder.length-1);
    }
    //use hashMap to get index by value
    private TreeNode helper(HashMap <Integer,Integer> inMap, int inLeft, int inRight,int [] preOrder, int preLeft, int preRight){
        //base case:
        if(inLeft>inRight){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preLeft]);
        int rootInorderIndex = inMap.get(root.key);
        //inorder: left root right
        //preorder: root left right
        int numOfLeftNodes = rootInorderIndex-inLeft;
        int numOfRightNodes = inRight-rootInorderIndex;
        root.left = helper(inMap,inLeft,rootInorderIndex-1,preOrder,preLeft+1,preLeft+numOfLeftNodes);
        root.right =helper(inMap,rootInorderIndex+1,inRight,preOrder,preRight-numOfRightNodes+1,preRight);
        return root;
    }

    private HashMap <Integer,Integer> inMap(int [] inOrder){
        //<Value,Index> we want to use Value to get the Index
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        return map;
    }
}
