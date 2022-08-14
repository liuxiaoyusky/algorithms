package RecursionIII;

import Tree.TreeNode;

public class ReconstrucBSTWithPostorderTraversal {
    //bst: left < root < right
    //post order: left right root
    public TreeNode reconstruct(int[] post) {
        return helper(post, 0, post.length - 1);
    }

    private TreeNode helper(int [] post, int left, int right) {
        //corner case
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(post[right]);
        if (left == right) {
            return root;
        }
        int lr = findLargestSmallerThanTarget(post, post[right], left, right - 1);
        root.left = helper(post, left, lr);
        root.right = helper(post, lr + 1, right - 1);
        return root;
    }

    private int findLargestSmallerThanTarget(int [] post, int target, int left, int right) {
        if (post[left] > target) {
            return left - 1;
        }

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (post[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (post[right] < target) {
            return right;
        }
        return left;
    }
}
