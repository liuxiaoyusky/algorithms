package Tree.BinarySearchTree;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

public class InOrderTraverseIterative {
    public List<Integer> inOrderTraverseIterative(TreeNode root) {
        //no assume
        //clarify TreeNode==null return empty
        List<Integer> ans=new ArrayList<Integer>();
        // if(root==null){
        //   return ans;
        // }
        Deque<TreeNode> stack=new LinkedList<TreeNode>();
        TreeNode cur=root;

        //cur could be null, but stack never store null value
        while(!stack.isEmpty()||cur!=null){
            //go to the left deapest node
            if(cur!=null){
                stack.offerFirst(cur);
                cur=cur.left;
            }
            else{
                cur=stack.pollFirst();
                ans.add(cur.key);
                cur=cur.right;
            }
        }
        return ans;
    }
}
