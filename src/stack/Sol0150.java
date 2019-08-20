package stack;

import java.util.Stack;

public class Sol0150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        int num1, num2;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    num2 = numStack.pop();
                    num1 = numStack.pop();
                    numStack.push(num1 + num2);
                    break;
                case "-":
                    num2 = numStack.pop();
                    num1 = numStack.pop();
                    numStack.push(num1 - num2);
                    break;
                case "*":
                    num2 = numStack.pop();
                    num1 = numStack.pop();
                    numStack.push(num1 * num2);
                    break;
                case "/":
                    num2 = numStack.pop();
                    num1 = numStack.pop();
                    numStack.push(num1 / num2);
                    break;
                default:
                    numStack.push(Integer.parseInt(token));
                    break;
            }
        }
        if (numStack.empty()) {
            return 0;
        } else {
            return numStack.peek();
        }
    }
}
