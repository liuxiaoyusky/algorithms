package Tree.小班;

import Tree.TreeNode;
//https://leetcode.com/problems/split-bst/

//time: O(height) Space:O(height)
public class SplitBST {

    //dfs
    //for every node, if root <= target, keep searching on right, right connect the returned root of smaller(0)
    //if root > target, keep finding the split point on root.left by helper, left connect the returned root of larger(1)
    //when return: return two current roots of smaller, larger
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.key <= target) {
            //[smaller, larger]
            TreeNode [] next = splitBST(root.right, target);
            root.right = next[0];
            return new TreeNode[] {root, next[1]};
        } else {
            TreeNode [] next = splitBST(root.left, target);
            root.left = next[1];
            return new TreeNode[]{next[0],root};
        }
    }

    //========================================================================
    //iterative
    public TreeNode[] splitBSTIterative(TreeNode root, int target) {
        TreeNode [] res = new TreeNode [2];
        TreeNode largestSmaller = null;
        TreeNode smallestLarger = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.key <= target) {
                if (res[0] == null) {
                    res[0] = cur;
                    largestSmaller = cur;
                }
                else {
                    largestSmaller.right = cur;
                    largestSmaller = cur;
                }
                cur = cur.right;
            } else {
                if (res[1] == null) {
                    res[1] = cur;
                    smallestLarger = cur;
                } else {
                    smallestLarger.left = cur;
                    smallestLarger = cur;
                }
                cur = cur.left;
            }
        }
        if (largestSmaller != null) {
            largestSmaller.right = null;
        }
        if (smallestLarger != null) {
            smallestLarger.left = null;
        }
        return res;
    }
}