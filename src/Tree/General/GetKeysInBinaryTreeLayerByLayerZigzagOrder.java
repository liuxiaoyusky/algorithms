package Tree.General;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
Get the list of keys in a given binary tree layer by layer in zig-zag order.
Examples
        5
      /    \
    3        8
  /   \        \
 1     4        11
the result is [5, 3, 8, 11, 4, 1]
Corner Cases
What if the binary tree is null? Return an empty list in this case.
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

//can also be done by one deque and a int count
public class GetKeysInBinaryTreeLayerByLayerZigzagOrder {
    //solution 2: one deque
    public List<Integer> zigZagII(TreeNode root){
        List <Integer>  ans = new ArrayList<Integer>();
        if(root == null){
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        int layer = 0;
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0;i<size;i++){
                if(layer == 0){
                   //at even layer, from right to left
                   TreeNode tmp = deque.pollLast();
                   ans.add(tmp.key);
                   if(tmp.right!=null){
                       deque.offerFirst(tmp.right);
                   }
                   if(tmp.left!=null){
                       deque.offerFirst(tmp.left);
                   }
                } else{
                    //at odd layer, from left to right
                    TreeNode tmp = deque.pollLast();
                    ans.add(tmp.key);
                    if(tmp.left!=null){
                        deque.offerFirst(tmp.left);
                    }
                    if(tmp.right!=null){
                        deque.offerFirst(tmp.right);
                    }
                }
            }
            layer = 1-layer;
        }
        return ans;
    }
    //solution 1: two stacks
    public List<Integer> zigZag(TreeNode root) {
        // use two stacks
        List <Integer> ans = new ArrayList<Integer>();
        if(root ==null){
            return ans;
        }
        Deque<TreeNode> oddRowStack = new ArrayDeque<>();
        Deque <TreeNode> evenRowStack = new ArrayDeque<>();
        oddRowStack.offerFirst(root);
        while(!oddRowStack.isEmpty()||!evenRowStack.isEmpty()){
            if(!oddRowStack.isEmpty()){
                while(!oddRowStack.isEmpty()){
                    TreeNode cur = oddRowStack.pollFirst();
                    ans.add(cur.key);
                    if(cur.right!=null){
                        evenRowStack.offerFirst(cur.right);
                    }
                    if(cur.left!=null){
                        evenRowStack.offerFirst(cur.left);
                    }
                }
            }else{
                while(!evenRowStack.isEmpty()){
                    TreeNode cur = evenRowStack.pollFirst();
                    ans.add(cur.key);
                    if(cur.left!=null){
                        oddRowStack.offerFirst(cur.left);
                    }
                    if(cur.right!=null){
                        oddRowStack.offerFirst(cur.right);
                    }
                }
            }
        }
        return ans;
    }
}
