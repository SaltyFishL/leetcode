package stack;

import java.util.*;

public class Sol0145 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> postorderList = new LinkedList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Set<TreeNode> visitedNode = new HashSet<>();

        if (root == null) {
            return postorderList;
        }
        TreeNode temp = root;
        while (temp != null) {
            nodeStack.push(temp);
            temp = temp.left;
        }

        while (!nodeStack.empty()) {
            temp = nodeStack.peek();
            if (temp.right != null && !visitedNode.contains(temp)) {
                visitedNode.add(temp);
                temp = temp.right;
                while (temp != null) {
                    nodeStack.push(temp);
                    temp = temp.left;
                }
            } else {
                postorderList.add(nodeStack.pop().val);
            }

        }

        return postorderList;
    }
}
