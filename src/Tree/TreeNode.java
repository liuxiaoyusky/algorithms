package Tree;

public class TreeNode {
    public Integer key;
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;//we usually don't use parent pointer

    public TreeNode(Integer key) {
        this.key = key;
        this.val = key;
    }

}
