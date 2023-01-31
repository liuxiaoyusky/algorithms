package Tree.General;


import java.util.ArrayList;
import java.util.List;
/*
Given two nodes in a K-nary tree, find their lowest common ancestor.
Assumptions
-There is no parent pointer for the nodes in the K-nary tree.
-The given two nodes are guaranteed to be in the K-nary tree.
Examples
        5
      /   \
     9   12
   / | \      \
 1 2   3      14
The lowest common ancestor of 2 and 14 is 5.
The lowest common ancestor of 2 and 9 is 9.
 */
public class LowestCommonAncestorV {

    static class KnaryTreeNode {
        int key;
        List<KnaryTreeNode> children;
        public KnaryTreeNode(int key) {
            this.key = key;
            this.children = new ArrayList<>();
        }
    }
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
        // cla: no parents, k children, given nodes garanteed in tree, could have dup?

        //base case: find the given nodes, or return lca to the top
        if(root == null){
            return null;
        }

        if(root==a||root==b){
            return root;
        }
        //k nodes recursion
        KnaryTreeNode found = null;
        for(KnaryTreeNode cur : root.children){
            cur = lowestCommonAncestor(cur,a,b);
            if(cur==null){
                continue;
            }else if(found == null){
                found = cur;
            }else{
                return root;
            }
        }
        return found;
    }
}