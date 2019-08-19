package stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Sol0094 {


   private class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;

       TreeNode(int x) {
           val = x;
       }
   }

    static public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> valList = new LinkedList<>();
        if (root == null) {
            return valList;
        }
        Stack<TreeNode> nodeStack = new Stack<>();

        TreeNode temp = root;
        while (temp != null) {
            nodeStack.push(temp);
            temp = temp.left;
        }

        while (!nodeStack.empty()) {
            if (nodeStack.peek().right != null) {
                temp = nodeStack.peek().right;
                valList.add(nodeStack.pop().val);
                while (temp != null) {
                    nodeStack.push(temp);
                    temp = temp.left;
                }
            } else {
                valList.add(nodeStack.pop().val);
            }
        }

        return valList;
    }

}
