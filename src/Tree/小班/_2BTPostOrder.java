package Tree.小班;

import Tree.TreeNode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-postorder-traversal/
public class _2BTPostOrder {
    //print in left,right root == inorder but print right first
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            ans.add(cur.key);

            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }

            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
        }

        Collections.reverse(ans);
        return ans;

    }
}