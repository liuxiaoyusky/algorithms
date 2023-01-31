package Tree.小班;

import Tree.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
public class _14LCA2 {
    class RT{
        int found;
        TreeNode lca;
        RT() {
            found = 0;
            lca = null;
        }
        RT(int f, TreeNode n) {
            found = f;
            lca = n;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        RT rt = helper(root, p, q);
        if (rt.found == 2) {
            return rt.lca;
        }
        return null;
    }

    private RT helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new RT();
        }

        RT left = helper(root.left, p, q);
        RT right = helper(root.right, p, q);


        //case 1: root == lca
        if (left.lca != null && right.lca != null) {
            return new RT(2, root);
        }

        //case 2: lca is found
        else if (left.found == 2 || right.found == 2) {
            return left.found == 2 ? left : right;
        }

        //case 3: root == p,q
        //3.1: p,q in subtree, return root, 2;
        //3.2: p,q not in subtree, return root,1;
        else if (root == p || root == q) {
            if (left.lca != null || right.lca != null) {
                return new RT(2, root);
            } else {
                return new RT(1, root);
            }
        }

        //case 4: root != p or q
        else {
            return left.lca != null ? left : right;
        }
    }
    //---solution 2----
    //assume both target nodes are not null and unique
    //step 1: find the target nodes
    //step 2: trace up to find the lca: for each such tree: 3 cases: no target node; 1 target node, 2 target node
    //case 0 : meaningless, return null
    //case 1 : return the target node to let upper level know
    //case 2 : 2.1 one target on each subtree, return root as our lca; 2.2 already find lca, and returned it from one subtree, return the lca
    //time: O(n) space: O(height)
    //assume all given nodes not null

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q, int [] counts) {
        //base case 0
        if (root == null) {
            return null;
        }


        //case 2
        TreeNode left = helper(root.left, p , q, counts);
        TreeNode right = helper(root.right, p, q, counts);

        //case 2.1
        if (left != null && right != null) {
            return root;
        }

        //case 1
        if (root == p || root == q) {
            counts[0]++;
            return root;
        }

        //case 2.2 or case 1
        else {
            return left == null ? right : left;
        }
    }


    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        int [] counts = {0};
        TreeNode lca = helper(root, p , q, counts);
        return counts[0] == 2 ? lca : null;
    }
}
