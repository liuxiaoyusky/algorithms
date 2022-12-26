package Tree.advanced;

import Tree.TreeNode;

public class LongestConsecutiveSequence {
    //at each root, we want to know if the subtree can is consecutive
    // (value + looking up or down)
    //update the max longest
    //
    //return both looking up and looking down value

    class RT{
        int ascendingLength;
        int descendingLength;
        public RT(int a, int d) {
            this.ascendingLength = a;
            this.descendingLength = d;
        }

    }
    public int findLongest(TreeNode root) {
        int [] longest = new int []{0};
        helper(root, longest);
        return longest[0];
    }

    private RT helper(TreeNode root, int [] longest) {
        //base case
        if (root == null) {
            return new RT(0,0);
        }

        if (root.left == null && root.right == null) {
            longest[0] = Math.max(longest[0], 1);
            return new RT(1,1);
        }
        //general case
        RT left = helper(root.left,longest);
        RT right = helper(root.right, longest);

        //in order for asc or des
        int longestAscLeft = root.left !=null && root.left.key + 1 == root.key ? left.ascendingLength + 1 : 1;
        int longestAscRight = root.right !=null && root.key == root.right.key - 1 ? right.ascendingLength + 1 : 1;
        int longestDesLeft = root.left !=null && root.left.key - 1 == root.key ? left.descendingLength + 1 : 1;
        int longestDesRight = root.right !=null && root.right.key + 1 == root.key ? right.descendingLength + 1 : 1;

        //case 1 ascending
        longest[0] = Math.max(longest[0], longestAscLeft + longestAscRight - 1);
        //case 2 descending
        longest[0] = Math.max(longest[0], longestDesLeft + longestDesRight - 1);

        return new RT(Math.max(longestAscLeft, longestDesRight), Math.max(longestAscRight, longestDesLeft));
    }
}
