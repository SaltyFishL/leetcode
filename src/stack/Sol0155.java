package stack;

import java.util.Stack;

public class Sol0155 {

    static class MinStack {
        Stack<Integer> dataStack;
        Stack<Integer> helperStack;

        /** initialize your data structure here. */
        public MinStack() {
            dataStack = new Stack<>();
            helperStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (helperStack.isEmpty() || helperStack.peek() > x) {
                helperStack.push(x);
            } else {
                helperStack.push(helperStack.peek());
            }
        }

        public void pop() {
            if (!dataStack.empty()) {
                dataStack.pop();
                helperStack.pop();
            }
        }

        public int top() {
            if (dataStack.empty()) {
                throw new RuntimeException("stack is empty");
            }
            return dataStack.peek();
        }

        public int getMin() {
            if (helperStack.empty()) {
                throw new RuntimeException("stack is empty");
            }
            return helperStack.peek();
        }
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
