package Tree.小班;

import Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class _3InOrder {
    //left root right
    //iterative

    //if left exist, add root to stack and traverse left
    //otherwise, add cur and check right
    //or if cur == null, poll one from stack, add it to ans and traverse right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pollFirst();
                ans.add(cur.key);

                cur = cur.right;
            } else {
                stack.offerFirst(cur);
                cur = cur.left;

            }

        }
        return ans;
    }
}