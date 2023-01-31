package Graph;

import Tree.TreeNode;

import java.util.*;

public class BuildGraph1 {
    //from tree to graph, the key is to remember the root
    //dfs, add parent value ahead
    public void buildGraphDFS(TreeNode root, Map<Integer, List<Integer>> map) {
        //corner case
        if (root == null) {
            return;
        }

        List<Integer> neig = map.get(root.key);
        if (neig == null) {
            neig = new ArrayList<>(3);
        }
        //put parent value to child key; put child value to cur key
        if (root.left != null) {
            neig.add(root.left.key);

            List<Integer> newList = new ArrayList<>(3);
            newList.add(root.key);
            map.put(root.left.key, newList);

            //keep going
            buildGraphDFS(root.left, map);
        }

        if (root.right != null) {
            neig.add(root.right.key);

            List<Integer> newList = new ArrayList<>(3);
            newList.add(root.key);
            map.put(root.right.key, newList);

            //keep going
            buildGraphDFS(root.right, map);
        }
    }

    public void buildGraphDFSII(TreeNode root, Map<Integer, List<Integer>> map, TreeNode parent) {
        if (root == null) {
            return;
        }
        List<Integer> nei = new ArrayList<>(3);
        if (parent != null) {
            nei.add(parent.key);
        }

        if (root.left != null) {
            nei.add(root.left.key);
            buildGraphDFSII(root.left, map, root);
        }

        if (root.right != null) {
            nei.add(root.right.key);
            buildGraphDFSII(root.right, map, root);
        }

        map.put(root.key, nei);
    }

    public void buildGraphBFS(TreeNode root, Map<Integer, List<Integer>> map) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        map.put(root.key, new ArrayList<>(3));
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            List<Integer> nei = map.get(cur.key);

            if (cur.left != null) {
                nei.add(cur.left.key);
                queue.offerLast(cur.left);
                List<Integer> childList = new ArrayList<>(3);
                childList.add(cur.key);
                map.put(cur.left.key, childList);
            }

            if (cur.right != null) {
                nei.add(cur.right.key);
                queue.offerLast(cur.right);
                List<Integer> childList = new ArrayList<>(3);
                childList.add(cur.key);
                map.put(cur.right.key, childList);
            }
        }
    }

    public static void main(String [] args) {
        String s = "hello";
        for (int i = 0; i < s.length(); i++) {
            String a = s.substring(0, i);
            String b = s.substring(i + 1);
            String next =  a + b;
            System.out.println(i);
            System.out.println("a :" + a);
            System.out.println("b :" + b);
            System.out.println("next :" + next);
        }
    }
}
