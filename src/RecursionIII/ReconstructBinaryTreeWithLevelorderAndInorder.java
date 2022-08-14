package RecursionIII;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithLevelorderAndInorder {
    //go through the in order search range, find the value with most front index in levelOrder
    //make this the current root, split inorder to two parts and continue
    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        Map<Integer, Integer> in = toMap(inOrder);
        Map<Integer, Integer> level = toMap(levelOrder);
        // int [] index = new int [1];
        return helper(in, inOrder, level, 0, inOrder.length - 1);
    }

    //
    private TreeNode helper(Map<Integer, Integer> in, int [] inOrder,
                            Map<Integer, Integer> level, int left, int right) {
        //base case
        if (left > right) {
            return null;
        }

        int levelIndex = inOrder.length;
        int curValue = -1;
        for(int i = left; i <= right; i++) {
            int newIndex= level.get(inOrder[i]);
            if (newIndex < levelIndex) {
                curValue = inOrder[i];
                levelIndex = newIndex;
            }
        }

        int inIndex = in.get(curValue);
        TreeNode root = new TreeNode(curValue);
        root.left = helper(in, inOrder, level, left, inIndex - 1);
        root.right = helper(in, inOrder, level, inIndex + 1, right);
        return root;
    }

    private Map<Integer, Integer> toMap(int [] arr) {
        Map<Integer, Integer> map = new HashMap<>();//value, index
        for (int i = 0; i < arr.length;i ++) {
            map.put(arr[i], i);
        }
        return map;
    }
}
