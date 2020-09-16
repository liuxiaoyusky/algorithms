package Tree.BinarySearchTree;


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
public class PreOrderTraverseIterative {
    public List<Integer> preOrder(TreeNode root) {
        //no assume, pre-order
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pollFirst();
            ans.add(cur.key);
            if(cur.right!=null){
                stack.offerFirst(cur.right);
            }
            if(cur.left!=null){
                stack.offerFirst(cur.left);
            }
        }

        return ans;
    }
}

