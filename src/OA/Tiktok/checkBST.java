package OA.Tiktok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class checkBST {
    //given string, check dup, check more than two parents, check mup roots
    public static String checkBST(String input) {
        String [] inputParts = input.split("[(]+");
        HashMap<Character,TreeNode> existingNodes = new HashMap<>();
        HashSet<TreeNode> roots = new HashSet<>();
        TreeNode root = null;

        //build nodes
        for (String pair : inputParts) {
            if (pair.length() < 3) {
                continue;
            }
            char parentValue = pair.charAt(0);

            //check if parent node exist
            TreeNode parentNode = existingNodes.get(parentValue);
            if (parentNode == null) {
                parentNode = new TreeNode(parentValue);
            }

            char childValue = pair.charAt(2);

            //check if parent node exist
            TreeNode childNode = existingNodes.get(childValue);
            if (childNode == null) {
                childNode = new TreeNode(childValue);
            }

            //check multi-parent
            TreeNode prevParent = childNode.parent;
            if (prevParent != null) {
                //check dup
                if (prevParent == parentNode){
                    return "dup pair";
                } else {
                    //multi-parent
                    return "multi-parent";
                }
            }
            //check invalid input
            if (childValue == parentValue) {
                return "same parent and child";
            }

            //check childs
            int numOfChilds = parentNode.childs.size();
            if (numOfChilds >= 2) {
                return "too much child";
            } else {
                //connect relation between parent and child
                parentNode.childs.add(childNode);
                roots.remove(childNode);

                childNode.parent = parentNode;
                roots.add(parentNode);

                existingNodes.put(childValue,childNode);
                existingNodes.put(parentValue,parentNode);
                root = parentNode;
            }
        }

        //check multi-root
        if (roots.size() > 1) {
            return "multi-roots";
        }

        //find root
        while (root != null) {
            if (root.parent != null) {
                root = root.parent;
            } else {
                break;
            }
        }

        //build s-expression
        StringBuilder stringBuilder = new StringBuilder();
        buildSExpression(stringBuilder,root);

        return stringBuilder.toString();
    }

    private static void buildSExpression(StringBuilder sb, TreeNode root) {
        //base case
        if (root == null) {
            return;
        }

        sb.append('(');
        sb.append(root.value);
        for(TreeNode child: root.childs){
            buildSExpression(sb,child);
        }
        sb.append(')');
    }

    public static void main(String [] args) {
        System.out.println(checkBST("(A,B),(A,D)"));
    }
}

class TreeNode {
    char value;
    TreeNode parent;
    List<TreeNode> childs;

    TreeNode (char value) {
        this.value = value;
        this.childs = new ArrayList<>();
    }
}