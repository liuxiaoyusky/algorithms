package Tree;
/*
Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.
Assumptions
There is parent pointer for the nodes in the binary tree
The given two nodes are not guaranteed to be in the binary tree
Examples
        5
      /   \
     9     12
   /  \      \
  2    3      14
The lowest common ancestor of 2 and 14 is 5
The lowest common ancestor of 2 and 9 is 9
The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
 */
//Time O(h) Space O(1)
public class LowestCommonAncestorII {
    public TreeNode lowestCommonAncestor(TreeNode one, TreeNode two) {
        // clarify: given two nodes are not garanteed to be in the binary tree， maybe in different tree?
        // has parent pointer, no root

        //step one: find length
        int lengthOne = findLength(one);
        int lengthTwo = findLength(two);

        //step two: find lca if exists
        if(lengthOne<lengthTwo){
            return LCAIIhelper(two,one,lengthTwo,lengthOne);
        }else{
            return LCAIIhelper(one,two,lengthOne,lengthTwo);
        }
    }
    private int findLength(TreeNode cur){
        int length = 0;
        while(cur!=null){
            cur = cur.parent;
            length++;
        }
        return length;
    }

    private TreeNode LCAIIhelper(TreeNode longer, TreeNode shorter, int lo, int sh){
        //move to the same layer
        while(sh<lo){
            longer = longer.parent;
            lo--;
        }

        //compare, and we actually don't need to take care of lo and sh here, just use while(longer!=shorter)
        while(lo>0){
            if(longer == shorter){
                return longer;
            }else{
                lo--;
                sh--;
                longer = longer.parent;
                shorter = shorter.parent;
            }
        }
        return null;
    }
}