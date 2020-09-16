package RecursionIII;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ReconstructTreeWithPreIn {
    public TreeNode reconstruct (int [] inOrder, int [] preOrder) {
        //clarify: given sequences are not null and same length; no dup
        Map <Integer, Integer> map = toMap (inOrder); // value:index

        //recursion
        return helper(inOrder, preOrder,map,0, inOrder.length - 1, 0, preOrder.length - 1);
    }

    //in: left root right
    //pre: root left right
    //[left,right] are the searching range
    private TreeNode helper (int [] inOrder, int [] preOrder, Map<Integer, Integer> map, int inLeft, int inRight, int preLeft, int preRight){
        //base case: when to return a null
        if (preLeft > preRight) {
            return null;
        }

        //common case
        //1.find the root
        int rootValue = preOrder[preLeft];
        TreeNode root = new TreeNode(rootValue);

        //2.find the range of left and right subtree
        int inIndex = map.get(rootValue);//find the index of root in inOrder
        int leftSubLength = inIndex - inLeft; // [inLeft, inIndex) is the left subTree
        TreeNode left = helper(inOrder, preOrder, map, inLeft, inIndex - 1, preLeft + 1, preLeft + leftSubLength);
        TreeNode right = helper(inOrder,preOrder, map, inIndex + 1, inRight, preLeft + leftSubLength + 1, preRight);
        root.left = left;
        root.right = right;

        //3.return the root
        return root;
    }

    //turn an array into a map: Value:Index; no dup value
    private Map <Integer,Integer> toMap (int [] array) {
        Map <Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<array.length; i++) {
            int value = array[i];
            map.put(value,i);
        }
        return map;
    }

    //solution 2: a more advanced way
     public TreeNode reconstruct2(int[] inOrder, int[] preOrder) {
       //clarify: given sequences are not null and same length; no dup
       int [] inIndex = new int [] {0};//save the index
       int [] preIndex = new int [] {0};//save the index
       //the recursion function
       return helperII(inOrder, preOrder, inIndex, preIndex, Integer.MAX_VALUE);
     }

     //1. find the root of its left and right subtree;
     //2. in each level, find the range of left subtree and right subtree. Upon the result, do the recursion:
         //pre: root left right
         //in: left root right
         //traverse in and pre the same time; target is the key of root,not necessarily left<root<right
         //we use target to identify the boundary of left subtree
     //3. return the root of current tree
     private TreeNode helperII(int [] in, int [] pre, int [] inIndex, int [] preIndex, int target){

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

    public static void main(String []args) {
        ReconstructTreeWithPreIn reconstructTreeWithPreIn = new ReconstructTreeWithPreIn();
        int [] pre = new int[]  {5, 3, 1, 4, 8, 11};
        int [] in = new int[]  {1, 3, 4, 5, 8, 11};
        reconstructTreeWithPreIn.reconstruct(in,pre);
    }
}
