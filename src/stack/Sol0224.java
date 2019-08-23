package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Sol0224 {

    private Map<Character, Integer> opPriority;

    {
        opPriority = new HashMap<>();
        opPriority.put('+', 1);
        opPriority.put('-', 1);
        opPriority.put('*', 2);
        opPriority.put('/', 2);
    }

    static private void calculateTwoNum(Stack<Integer> numStack, Character op) {
        int num2 = numStack.pop();
        int num1 = numStack.pop();

        switch (op) {
            case '+':
                numStack.push(num1 + num2);
                break;
            case '-':
                numStack.push(num1 - num2);
                break;
            case '*':
                numStack.push(num1 * num2);
                break;
            case '/':
                numStack.push(num1 / num2);
                break;
            default:
                throw new RuntimeException("optionError");
        }
    }

    public int calculate(String s) {
        if (s == null) {
            return 0;
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char temp = s.charAt(i);
            switch (temp) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!(opStack.empty() || opStack.peek() == '(' || opPriority.get(temp) > opPriority.get(opStack.peek()))) {
                        calculateTwoNum(numStack, opStack.pop());
                    }
                    opStack.push(temp);
                    break;
                case '(':
                    opStack.push(temp);
                    break;
                case ')':
                    while (opStack.peek() != '(') {
                        calculateTwoNum(numStack, opStack.pop());
                    }
                    opStack.pop();
                    break;
                case ' ':
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        stringBuilder.append(s.charAt(i));
                        i++;
                    }
                    i--;
                    numStack.push(Integer.parseInt(stringBuilder.toString()));
                    break;
            }

        }

        while (!opStack.empty()) {
            calculateTwoNum(numStack, opStack.pop());
        }

        return numStack.pop();
    }

    public static void main(String[] args) {
        String[] tests = {"1 + 1",
                "2-1 + 2 ",
                "(1+(4+5+2)-3)+(6+8)",
                "3 - 2- 2",
                "1 * 2+5/2-2-1*10",};
        Sol0224 sol = new Sol0224();
        for (String test : tests) {
            System.out.println(sol.calculate(test));
        }

    }
}
