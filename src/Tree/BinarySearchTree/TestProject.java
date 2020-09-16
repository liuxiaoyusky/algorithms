package Tree.BinarySearchTree;

import Tree.TreeNode;

public class TestProject {
    public static void main(String[] args){

        TreeNode oneNode=new TreeNode(12132);
        TreeNode twoNode=new TreeNode(213213);
        twoNode.left=oneNode;

        //build a tree
        TreeNode root=new TreeNode(10);
        TreeNode node2=new TreeNode(2);
        TreeNode node7=new TreeNode(7);
        TreeNode node123=new TreeNode(123);
        TreeNode node32=new TreeNode(32);
        TreeNode node8=new TreeNode(8);
        TreeNode node76=new TreeNode(76);
        root.left=node2;
        root.right=node76;
        node2.right=node7;
        node7.right=node8;
        node76.left=node32;
        node76.right=node123;


     //TraverseBST traverseBST=new TraverseBST();
     //traverseBST.printTreeInLevelOrder(root);
     DeleteInBST deleteInBST = new DeleteInBST();
     deleteInBST.deleteTree(root, 76);

    }
}
