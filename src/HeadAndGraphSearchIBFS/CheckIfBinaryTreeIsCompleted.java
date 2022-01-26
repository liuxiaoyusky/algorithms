package HeadAndGraphSearchIBFS;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
/*
Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree
is completely filled except possibly the last level.
Furthermore, all nodes are as far left as possible.
Examples
        5
      /    \
    3        8
  /   \
1      4
is completed.
        5
      /    \
    3        8
  /   \        \
1      4        11
is not completed.
Corner Cases
    What if the binary tree is null? Return true in this case.
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
public class CheckIfBinaryTreeIsCompleted {
    //global flag for complete; if flag == true, there should be no more nodes added to the queue
    //go through level by level, it is complete if flag == true and no mare nodes added to the queue
    public boolean isCompleted(TreeNode root) {
        //base case
        if (root == null) {
            return true;
        }

        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();//or ArrayDeque
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                //should be no more new nodes but new node exists, return false
                return false;
            } else {
                queue.offer(cur.left);
            }

            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                //should be no more new nodes but new node exists, return false
                return false;
            } else {
                queue.offer(cur.right);
            }
        }

        return true;
    }

}
