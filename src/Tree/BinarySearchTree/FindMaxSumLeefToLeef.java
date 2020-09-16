package Tree.BinarySearchTree;

import Tree.TreeNode;

public class FindMaxSumLeefToLeef {
    public int maxSum(TreeNode root){
        int [] result={Integer.MIN_VALUE};
        helper(root,result);
        return result[0];
    }

    private int helper(TreeNode root, int [] result){
        if(root==null){
            return 0;
        }


        //leaf
        if(root.left==null&&root.right==null){
            return root.key;
        }

        int left=helper(root.left,result);
        int right=helper(root.right,result);
        int cur=left+right+root.key;

        //have both child,possible max
        if(root.left!=null&&root.right!=null){
            result[0]=Math.max(result[0],cur);
            return root.key+Math.max(left,right);
        }

        //only one child
        return root.left==null? root.key+right: root.key+left;
    }
}
