package stack;

import java.util.Stack;

public class Sol0394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        int startIndex, endIndex;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                startIndex = i;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    i++;
                }
                endIndex = i;
                i--;
                stack.push(s.substring(startIndex, endIndex));
            } else if (s.charAt(i) == '[') {
                stack.push("[");
            } else if (s.charAt(i) == ']') {

                StringBuilder str = new StringBuilder(stack.pop());
                while (!stack.empty() && !stack.peek().equals("[")) {
                    str.insert(0, stack.pop());
                }

                StringBuilder sb = new StringBuilder();
                stack.pop();
                int num = Integer.parseInt(stack.pop());
                while (num-- > 0) {
                    sb.append(str);
                }
                stack.push(sb.toString());
            } else {
                startIndex = i;
                while (i < s.length() &&
                        (s.charAt(i) < '0' || s.charAt(i) > '9') &&       //not number
                        s.charAt(i) != '[' &&                           //not '['
                        s.charAt(i) != ']') {                           //not ']'
                    i++;
                }
                endIndex = i;
                i--;
                stack.push(s.substring(startIndex, endIndex));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.empty()) {
            stringBuilder.insert(0, stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Sol0394 sol0394 = new Sol0394();

        String[] tests = {
                "3[a]2[bc]",
                "3[a2[c]]",
                "2[abc]3[cd]ef",
                "3[a10[cb]bcd]"
        };

        for (String test : tests) {
            System.out.println(sol0394.decodeString(test));
        }
    }
}
