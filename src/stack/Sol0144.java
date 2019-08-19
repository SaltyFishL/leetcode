package stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Sol0144 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new LinkedList<>();
        if (root == null) {
            return preorderList;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.empty()) {
            TreeNode temp = nodeStack.pop();
            preorderList.add(temp.val);
            if (temp.right != null) {
                nodeStack.push(temp.right);
            }
            if (temp.left != null) {
                nodeStack.push(temp.left);
            }
        }

        return preorderList;
    }
}
