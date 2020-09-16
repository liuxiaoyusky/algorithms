package Tree;

import java.util.ArrayList;
import java.util.List;
/*
Given M nodes in a K-nary tree, find their lowest common ancestor.
Assumptions
- M >= 2.
- There is no parent pointer for the nodes in the K-nary tree.
- The given M nodes are guaranteed to be in the K-nary tree.
Examples
        5
      /   \
     9   12
   / | \      \
  1 2 3     14
The lowest common ancestor of 2, 3, 14 is 5.
The lowest common ancestor of 2, 3, 9 is 9.
 */
public class LowestCommonAncestorVI {
     static class KnaryTreeNode {
         int key;
         List<KnaryTreeNode> children;
         public KnaryTreeNode(int key) {
             this.key = key;
             this.children = new ArrayList<>();
         }
     }

    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
        //clarify: all given nodes guarante to be in the k-nary tree
        if(root ==null){
            return null;
        }

        //base case
        for(KnaryTreeNode cur: nodes){
            if(root == cur){
                return root;
            }
        }

        KnaryTreeNode found = null;
        for(KnaryTreeNode cur: root.children){
            cur = lowestCommonAncestor(cur,nodes);
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