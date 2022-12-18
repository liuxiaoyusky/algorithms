package Tree.advanced;
/*
390. Determine If Binary Tree Is Min Heap
Medium

Determine if the given binary tree is min heap.

 
 */
public class IfBinaryTreeIsMinHeap8 {
    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
         this.key = key;
        }
    }

    //minheap if :
    //1.    root < left < right(heapify)
    //2.    is a completeTree

    class RT{
        int min;
        boolean isComplete;
        int height;
        boolean isPerfect;
        boolean isMinHeap;
        public RT(int min, boolean c, int h, boolean p, boolean m) {
            this.min = min;
            this.isComplete = c;
            this.height = h;
            this.isPerfect = p;
            this.isMinHeap = m;
        }
    }

    public boolean isMinHeap(TreeNode root) {
        return helper(root).isMinHeap;
    }

    private RT helper(TreeNode root) {
        if (root == null) {
            return new RT(Integer.MAX_VALUE, true, 0, true, true);
        }

        RT left = helper(root.left);
        RT right = helper(root.right);
        //check valid, check heapify
        if (!left.isMinHeap || !right.isMinHeap || root.key > left.min || root.key > right.min) {
            return new RT(-1, false, -1, false, false);
        }
        //check complete
        //case 1: complete + perfect, left.height = right.height + 1
        if (left.isComplete && right.isPerfect && left.height == right.height + 1) {
            return new RT(root.key, true, left.height + 1, false, true);
        }

        //case 2: perfect + complete/perfect, left height = right height
        if (left.isPerfect && right.isComplete && left.height == right.height) {
            return new RT(root.key, true, left.height + 1, right.isPerfect, true);
        }

        else {
            return new RT(-1, false, -1, false, false);
        }
    }
}
