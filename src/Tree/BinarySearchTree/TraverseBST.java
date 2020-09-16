package Tree.BinarySearchTree;

import Tree.TreeNode;

import java.util.*;

public class TraverseBST {

    public List<Integer> printTreeInLevelOrder(TreeNode root){
        List <Integer> list=new LinkedList<>();
        //conner case
        if(root==null){
            return list;
        }

        //put node into FIFO queue,both Deque and Queue are implementable
        Deque<TreeNode> tree= new ArrayDeque<>();
        tree.offer(root);
        while (!tree.isEmpty()){
            TreeNode cur=tree.pollFirst();
            System.out.println(cur.key);
            if(cur.left!=null){
                tree.offerFirst(cur.left);
            }
            if(cur.right!=null) {
                tree.offerFirst(cur.right);
            }
        }
        Queue<TreeNode> queue=new LinkedList<>();
        list.clear();
        return list;
    }

    public List<Integer> inOrderByIteration(TreeNode root){
        List<Integer> list=new LinkedList<>();
        if(root==null){
            return list;
        }
        TreeNode cur;
        Deque<TreeNode> stack=new LinkedList<>();
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            cur=stack.pollLast();
            System.out.println(cur.key);
            if(cur.left!=null){
                stack.offerLast(cur.left);
            }
            if(cur.right!=null) {
                stack.offerLast(cur.right);
            }

        }

        return list;
    }
}
