package Tree;

import Tree.General.IntArrayToTree;
import org.junit.jupiter.api.Test;

class IntArrayToTreeTest {

    @Test
    void toTree() {
        Integer [] array = new Integer[] {0, 3, 9, 2, 4, null, null, 1, 3, 5, null, null, null, null, 4};
        IntArrayToTree i = new IntArrayToTree();
        TreeNode root = i.toTree(array);
        i.printTree(root);

    }
}