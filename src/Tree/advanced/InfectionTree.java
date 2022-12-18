package Tree.advanced;

import Tree.TreeNode;
/*
2385. Amount of Time for Binary Tree to Be Infected
Medium
757
11
Companies

You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

Each minute, a node becomes infected if:

    The node is currently uninfected.
    The node is adjacent to an infected node.

Return the number of minutes needed for the entire tree to be infected.

 

Example 1:

Input: root = [1,5,3,null,4,10,6,9,2], start = 3
Output: 4
Explanation: The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.

Example 2:

Input: root = [1], start = 1
Output: 0
Explanation: At minute 0, the only node in the tree is infected so we return 0.

 

Constraints:

    The number of nodes in the tree is in the range [1, 105].
    1 <= Node.val <= 105
    Each node has a unique value.
    A node with a value of start exists in the tree.

Accepted
19.7K
Submissions
 */
public class InfectionTree {
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

    public int amountOfTime(TreeNode root, int start) {
        int [] max = new int [] {0};
        helper(root, start, max);
        return max[0];
    }

    private int helper(TreeNode root, int start, int [] max) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left, start, max);
        int right = helper(root.right, start, max);

        //general case
        //case 1: on the point
        if (root.key == start) {
            max[0] = Math.max(left, right);
            return -1;
        }

        //case 2: both not found, return true height
        if (left >= 0 && right >= 0) {
            return Math.max(left, right) + 1;
        }

        //case 3: found infection on one side, try update max, return the height of infection
        max[0] = Math.max(max[0], Math.abs(left) + Math.abs(right));
        int returnValue = left < 0 ? left - 1 : right - 1;
        return returnValue;
    }

    //solution 2-------------------------------------------
    class ReturnType {
        boolean found;
        int distanceToStartOrHeight;
        public ReturnType (boolean found, int distanceToStartOrHeight) {
            this.found = found;
            this.distanceToStartOrHeight = distanceToStartOrHeight;
        }
    }
    public int amountOfTimeII(TreeNode root, int start) {
        int [] max = new int [] {0};
        helperII(root, start, max);
        return max[0];
    }

    private ReturnType helperII(TreeNode root, int start, int [] max) {
        if (root == null) {
            return new ReturnType(false, 0);
        }

        ReturnType left = helperII(root.left, start, max);
        ReturnType right = helperII(root.right, start, max);

        //general case
        //case 1: on the point
        if (root.key == start) {
            max[0] = Math.max(left.distanceToStartOrHeight, right.distanceToStartOrHeight);
            return new ReturnType(true, 0);
        }

        //case 2: both not found, return true height
        if (!left.found && !right.found) {
            return new ReturnType(false, Math.max(left.distanceToStartOrHeight, right.distanceToStartOrHeight) + 1);
        }

        //case 3: found infection on one side, try update max, return the height of infection
        max[0] = Math.max(max[0], left.distanceToStartOrHeight + right.distanceToStartOrHeight + 1);
        int returnValue = left.found ? left.distanceToStartOrHeight + 1 : right.distanceToStartOrHeight + 1;
        return new ReturnType(true, returnValue);
    }
}