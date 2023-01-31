package Tree;


import Tree.General.ReverseBinaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class TestTree {
    public static void main(String [] args){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);
        TreeNode node9=new TreeNode(9);
        TreeNode node10=new TreeNode(10);
        TreeNode node11=new TreeNode(11);

        node1.left=node2;
        node1.right=node3;

        ReverseBinaryTree reverseBinaryTree = new ReverseBinaryTree();
        reverseBinaryTree.reverse(node1);
        System.out.println(print(node1));
    }

    private static String print(TreeNode root){
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.pollFirst();
            sb.append(cur.key+" ");
            if(cur.left!=null){
                queue.offerLast(cur.left);
            }
            if(cur.right!=null) {
                queue.offerLast(cur.right);
            }
        }

        return sb.toString();
    }
}
