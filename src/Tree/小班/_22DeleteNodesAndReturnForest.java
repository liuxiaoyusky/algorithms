package Tree.小班;

import Tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/delete-nodes-and-return-forest/description/
public class _22DeleteNodesAndReturnForest {
    //solution

//  Definition for a binary tree node.

    //at each level, check if current node is to be deleted
    //if so, delete it and check the child nodes
    //if not, check if parent nodes exists, if not, add current to newRoots

    //to delete it completely, need a parent node to delete from the top end


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<>();
        for (int num : to_delete) {
            toDelete.add(num);
        }
        List<TreeNode> newRoots = new LinkedList<>();
        checkDelete(root, null, toDelete, newRoots);
        return newRoots;
    }

    private void checkDelete(TreeNode cur, TreeNode prev, Set<Integer> toDelete, List<TreeNode> newRoots) {
        if (cur == null) {
            return ;
        }

        boolean needNewRoot = false;
        //could be dup val
        if (toDelete.contains(cur.val)) {
            needNewRoot = true;
            deleteChild(prev, cur);
        } else {
            if (prev == null) {
                newRoots.add(cur);
            }
        }


        TreeNode newPrev = needNewRoot ? null : cur;

        checkDelete(cur.left, newPrev, toDelete, newRoots);
        checkDelete(cur.right, newPrev, toDelete, newRoots);
    }

    private void deleteChild(TreeNode parent, TreeNode cur) {
        if (parent == null) {
            return;
        }

        if (parent.left == cur) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }
}
