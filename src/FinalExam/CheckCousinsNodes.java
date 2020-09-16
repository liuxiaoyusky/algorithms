package FinalExam;

    /*Check if two nodes are cousins in a Binary Tree
    Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.
    Two nodes are cousins of each other if they are at same level and have different parents.

    Example:

                      6

                  /     \

               3            5

            /     \      /    \

         7         8    1       2
    7 and 1, result is TRUE
    3 and 5, result is FALSE
    7 and 5, result is FALSE*/

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
//solution 1 by DFS
public class CheckCousinsNodes {
    //clarify: two nodes, so no dup
    //find the level of two nodes and compare the value
    //corner case: check if they have the same parents when traverse
    public boolean checkCousinsNodes(TreeNode root,TreeNode a, TreeNode b){
        if(root==null){
            return false;
        }
        int [] level=new int [2];
        checkCousinsNodesHelper(root, a, b,level);
        return level[0]==level[1];
    }
    private void checkCousinsNodesHelper(TreeNode root, TreeNode a,TreeNode b, int [] level){
        //reach the base
        if(root==null){
            return;
        }

        //brother a,b; make a to -1 and make result false
        if(level[0]==1){
            if(matchCousins(root.left,a,b)&&matchCousins(root.right,a,b)){
                level[0]=-1;
                return;
            }
        }


        //find both nodes,count levels when backtrack
        if(level[0]!=-1&&level[1]!=-1){
            level[0]++;
            level[1]++;
            return;
        }



        //check if root==a or b, set level two
        if(root==a){
            level[0]=0;
            return;
        }else if(root==b){
            level[1]=0;
            return;
        }

    }
    ///---------------------
    //solution2 BFS
    public boolean checkCousinsBFS(TreeNode root, TreeNode a, TreeNode b){
        if(root==null){
            return false;
        }

        //no matter what is root.right, a and b are not cousins
        if(matchCousins(root,a,b)){
            return false;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean curlevel=false;
        int count=0;
        while(!queue.isEmpty()&& curlevel==false&&count<2){
            //check nodes when generate
            for(int i=0;i<queue.size();i++){
                TreeNode cur=queue.poll();
                if(matchCousins(cur.left,a,b)){
                    curlevel=true;
                    count++;
                    if(matchCousins(cur.right,a,b)){
                        return false;
                    }
                }
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return count==2;
    }

    //check if root==a or b
    private boolean matchCousins(TreeNode root, TreeNode a,TreeNode b){
        if(root==a||root==b){
            return true;
        }
        return false;
    }
    //--------------------------------------------------------
    //solution 3 by LCA
    //assume no dup
//like lca, do it by recursion
//input tree,a,b output boolean
//each level, check children==a or b


    //Space O(1) time:O(height,most time logn)
    public boolean checkCousins(TreeNode root,TreeNode a, TreeNode b){
        if(root==null){
            return false;
        }

        return checkCousinsHelper(root,a,b,false);
    }

    private boolean checkCousinsHelper(TreeNode root,TreeNode a, TreeNode b,boolean findIt){

        if(root==null){
            return false;
        }

        //corner case like 35
        if((root.left==a&&root.right==b)||(root.left==b&&root.right==a)){
            return false;
        }

        //find it, return true to grandparents
        if(root.left==a||root.right==a||root.left==b||root.right==b){
            return true;
        }

        boolean left=checkCousinsHelper(root.left,a,b,findIt);
        boolean right=checkCousinsHelper(root.right,a,b,findIt);

        //check if my childrens are the parents of two cousins
        if(left==true&&right==true){
            findIt=true;
            return findIt;
        }

        //find the right answer, return findIt
        return findIt;
    }
}
