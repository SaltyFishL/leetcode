package stack;

import java.util.Stack;

public class Sol0173 {
    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class BSTIterator {

        Stack<TreeNode> minStack;

        public BSTIterator(TreeNode root) {
            minStack = new Stack<>();
            TreeNode temp = root;
            while (temp != null) {
                minStack.push(temp);
                temp = temp.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode temp = minStack.pop();
            int res = temp.val;
            if (temp.right != null) {
                temp = temp.right;
                while (temp != null) {
                    minStack.push(temp);
                    temp = temp.left;
                }
            }
            return res;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !minStack.empty();
        }
    }
}
