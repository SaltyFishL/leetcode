package stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Sol0103 {
    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagList = new LinkedList<>();
        if (root == null) {
            return zigzagList;
        }
        List<Integer> layerList;
        Stack<TreeNode> leftNodeStack = new Stack<>();
        Stack<TreeNode> rightNodeStack = new Stack<>();
        leftNodeStack.push(root);

        while (!leftNodeStack.empty() || !rightNodeStack.empty()) {
            layerList = new LinkedList<>();
            if (!leftNodeStack.empty()) {
                while (!leftNodeStack.empty()) {
                    TreeNode temp = leftNodeStack.pop();
                    layerList.add(temp.val);
                    if (temp.left != null) {
                        rightNodeStack.push(temp.left);
                    }
                    if (temp.right != null) {
                        rightNodeStack.push(temp.right);
                    }
                }
            } else {
                while (!rightNodeStack.empty()) {
                    TreeNode temp = rightNodeStack.pop();
                    layerList.add(temp.val);
                    if (temp.right != null) {
                        leftNodeStack.push(temp.right);
                    }
                    if (temp.left != null) {
                        leftNodeStack.push(temp.left);
                    }
                }
            }
            zigzagList.add(layerList);
        }
        return zigzagList;
    }
}
