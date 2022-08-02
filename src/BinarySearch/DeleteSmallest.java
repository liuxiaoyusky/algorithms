package BinarySearch;

public class DeleteSmallest {

    public TreeNode deleteTree(TreeNode root, int key) {
        //corner case
        if (root == null) {
            return null;
        }

        if (root.key == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            } else {
                TreeNode newNode = deleteSmallest(root.right);
                newNode.left = root.left;
                newNode.right = root.right;
                return newNode;
            }
        } else if (root.key < key) {
            root.right = deleteTree(root.right, key);
        } else {
            root.left = deleteTree(root.left, key);
        }
        return root;
    }

    private TreeNode deleteSmallest(TreeNode root) {
        while (root.left.left != null) {
            root = root.left;
        }
        TreeNode newRoot = root.left;
        root.left = root.left.right;
        return newRoot;
    }
    //--------------------------------------------
    //when delete,
    // 1.if left or right is null, return the child
    // 2.if both not null, pick largest node smaller than key from left subtree;since largest,
    // it must not have right child，so let k's parent's left = k's right child,let k's left and right =
    // target's left and right
    //this solution delete largest smaller node first
    public TreeNode deleteTreeII(TreeNode root, int key) {
        //corner case
        if (root == null) {
            return null;
        }

        if (root != null) {
            if (root.key == key) {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else if (root.left.right == null) {
                    root.left.right = root.right;
                    return root.left;
                }else {
                    TreeNode newNode = deleteLargest(root.left);
                    newNode.left = root.left;
                    newNode.right = root.right;
                    return newNode;
                }
            } else if (root.key < key) {
                root.right = deleteTree(root.right, key);
            } else {
                root.left = deleteTree(root.left, key);
            }
        }
        return root;
    }

    //1.root = null is included above
    //2. root.right = null, included above
    private TreeNode deleteLargest(TreeNode root) {
        while (root.right.right != null) {
            root = root.right;
        }
        TreeNode next = root.right;
        root.right = root.right.left;
        return next;
    }
}
