package Tree;

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
public class ReverseBinaryTree {
    //bad question
    public TreeNode reverse(TreeNode root) {
        // do it recursively
        // important to understand the question: all the right nodes are left nodes
    /*
    root       l
    / \  =>   / \
    l  r   root  r
    doesn't flip if left node is not exist
    */

        //base case
        if(root == null || root.left == null){
            return root;
        }

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        TreeNode headNode = reverse(leftNode);
        root.left.left = root;
        root.left.right = rightNode;
        root.left = null;
        root.right = null;

        return headNode;
    }
}

