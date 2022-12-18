package Tree.advanced;

import Tree.TreeNode;

/*
Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.
 */
public class IsCompleteTree3 {
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
        class ReturnType {
            boolean isPerfect;
            boolean isComplete;
            int height;
            public ReturnType(boolean p, boolean c, int h) {
                isPerfect = p;
                isComplete = c;
                height = h;
            }
        }

        public boolean isCompleted(TreeNode root) {
            return helper(root).isComplete;
        }

        private ReturnType helper(TreeNode root) {
            if (root == null) {
                return new ReturnType(true, true, 0);
            }

            ReturnType left = helper(root.left);
            ReturnType right = helper(root.right);

            if (!left.isComplete || !right.isComplete) {
                return new ReturnType(false, false, 0);
            }

            //case 1: perfect
            if (left.isPerfect && right.isPerfect && left.height - right.height  == 0) {
                return new ReturnType(true, true, left.height + 1);
            }

            //case 2: left is complete, right is perfect
            if (left.isComplete && right.isPerfect && left.height - right.height  == 1) {
                return new ReturnType(false, true, left.height + 1);
            }

            //case 3: left is perfect, right is complete
            if (left.isPerfect && right.isComplete && left.height - right.height  == 0) {
                return new ReturnType(false, true, left.height + 1);
            }

            return new ReturnType(false, false, 0);
        }
    }

