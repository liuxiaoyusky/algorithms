package CrossTrainingI;

import Tree.TreeNode;

import java.util.*;

/*
In a binary search tree, find k nodes containing the closest numbers to the given target number. return them in sorted array

Assumptions:

    The given root is not null.
    There are no duplicate keys in the binary search tree.

Examples:

    5

  /    \

2      11

     /    \

    6     14

closest number to 4 is 5

closest number to 10 is 11

closest number to 6 is 6

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
 */
public class ClosestNumInBSTII {
    // naive way: by priority queue
    // clarify: root not null, no dup, return in sorted int []
    // suppose n nodes in tree; takes nlogn time to pq, plus nlogn time to sort, Time: O(nlogn)
    // space: O(n)
    public int[] closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            //Compares its two arguments for order. Returns a negative integer, zero, or a positive integer as the first
            // argument is less than, equal to, or greater than the second.
            @Override
            public int compare(Integer o1, Integer o2) {
                double first = Math.abs(o1 - target);
                double second = Math.abs(o2 - target);
                return first > second ? 1 : (first == second ? 0 : -1);
            }
        });

        preOrderTraverse(root, target, k, pq); //recursion function

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Integer cur = pq.poll();
            if (cur != null) {
                ans.add(cur);
            } else {
                break;
            }
        }

        Collections.sort(ans);
        int [] res = new int [ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    //recursion function
    private void preOrderTraverse(TreeNode root, double target, int k, PriorityQueue<Integer> pq) {
        //base case
        if (root == null) {
            return;
        }

        pq.offer(root.key);
        preOrderTraverse(root.left, target, k, pq);
        preOrderTraverse(root.right, target, k, pq);
    }

    //---------------------------------------------------------------------------------------------------
    // a faster way: in-order traverse, do the prefix sum, find the next most related target on either left or right side
    // clarify: root not null, no dup, return in sorted int []
    public int[] closestKValuesII(TreeNode root, double target, int k) {
        Deque<Integer> deque = new LinkedList<>();
        inOrderTraverse(root, target, k, deque);
        //could have less than k nodes
        int n = Math.min(deque.size(), k);
        int [] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = deque.pollFirst();
        }
        return ans;
    }

    private void inOrderTraverse(TreeNode root, double target, int k, Deque<Integer> deque) {
        //base case
        if (root == null) {
            return;
        }

        inOrderTraverse(root.left, target, k, deque);
        if (deque.size() < k) {
            deque.offerLast(root.key);
        } else {
            double newNum = Math.abs(root.key - target);
            double cur = Math.abs(deque.peekFirst() - target);
            if (newNum < cur) {
                //update, keep searching next
                deque.pollFirst();
                deque.offerLast(root.key);
            } else {
                //sorted array, we already find all ans in our deque
                return;
            }
        }
        inOrderTraverse(root.right, target, k, deque);
    }
}
