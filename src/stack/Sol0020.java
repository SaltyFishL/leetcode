package stack;

import java.util.Scanner;
import java.util.Stack;

public class Sol0020 {
    static public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '[' || temp == '{') {
                bracketStack.push(temp);
            } else {
                if (bracketStack.empty()) {
                    return false;
                }

                if (temp == ')' && bracketStack.peek() == '(') {
                    bracketStack.pop();
                } else if (temp == ']' && bracketStack.peek() == '[') {
                    bracketStack.pop();
                } else if (temp == '}' && bracketStack.peek() == '{') {
                    bracketStack.pop();
                } else {
                    return false;
                }
            }
        }
        return bracketStack.empty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(isValid(s));
        }
    }
}
