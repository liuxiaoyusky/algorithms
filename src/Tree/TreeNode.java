package Tree;

public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;//we usually don't use parent pointer

    public TreeNode(int key){
        this.key=key;
    }

}
