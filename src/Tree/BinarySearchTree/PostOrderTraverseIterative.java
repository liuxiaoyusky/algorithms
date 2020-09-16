package Tree.BinarySearchTree;

import Tree.TreeNode;

import java.util.*;

public class PostOrderTraverseIterative {
    //left right root ==> inverse: root right left
    public List<Integer> postOrder(TreeNode root) {
        List <Integer> ans=new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            ans.add(cur.key);
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }

            if(cur.right != null) {
                stack.offerFirst(cur.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    //solution2
    public List<Integer> postOrderII(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque <TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);

        //to record the previous node on the way of DFS so that we can determine the direction.
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            // if we are going down, either left/right direction
            if (prev == null || cur == prev.left || cur == prev.right) {
                //if we still go down, try go left first
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    //if we can not go either way, meaning cur is a leaf node
                    stack.pollFirst();
                    result.add(cur.key);
                }
            } else if (prev == cur.right || prev == cur.left && cur.right == null) {
                // if we are going up from the right side or going up from the left side
                // but we can not go right afterwards
                stack.pollFirst();
                result.add(cur.key);
            } else {
                //other wise, we are going up from the left seide and we can go down right side
                stack.offerFirst(cur.right);
            }
            prev = cur;
        }
        return result;
    }
}


