package Tree.BinarySearchTree;


import Tree.TreeNode;
import com.sun.source.tree.Tree;

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
public class DeleteInBST {
    public TreeNode deleteTree(TreeNode root, int key) {
        // assume: the smallest larger node is first candidate after deletion
        //no dup, return null if not exist
        //input root, output root
        if(root == null){
            return null;
        }

        if(root.key==key){
            //return node that should take place of the deleted one
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode newHead =  findAndDeleteSmallestLarger(root.right);
                //root's right subtree is connected to newHead, now connnect the left One
                newHead.left = root.left;
                return newHead;
            }
        }else if(key>root.key){
            root.right = deleteTree(root.right,key);
        }else{
            root.left = deleteTree(root.left,key);
        }

        return root;
    }

    private TreeNode findAndDeleteSmallestLarger(TreeNode root){
        //return smallest Larger node
        if(root.left == null){
            return root;
        }
        TreeNode cur = root;
        while(cur.left.left!=null){
            cur=cur.left;
        }

        //delete target from original tree
        TreeNode target = cur.left;
        cur.left=target.right;

        //connect target to
        target.right = root;

        return target;
    }

}
