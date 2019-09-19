package stack;

import java.util.Stack;

public class Sol0331 {
    public boolean isValidSerialization(String preorder) {

        int startIndex = 0;
        int nextCommaIndex = findNextIndex(',', startIndex, preorder);

        if (preorder.charAt(startIndex) == '#' && nextCommaIndex == -1) {   //只有一个节点, 且根节点为#
            return true;
        } else if (preorder.charAt(startIndex) == '#' && nextCommaIndex != -1) {    //多个节点, 且根节点为#
            return false;
        } else if (preorder.charAt(startIndex) != '#' && nextCommaIndex == -1) {    //只有一个节点, 且根节点不为#
            return false;
        }

        //至少有两个节点, 且根节点不为#
        Stack<Integer> stack = new Stack<>();
        int num = Integer.parseInt(preorder.substring(startIndex, nextCommaIndex));
        stack.push(num);
        stack.push(num);

        do {
            startIndex = nextCommaIndex + 1;
            nextCommaIndex = findNextIndex(',', startIndex, preorder);
            if (preorder.charAt(startIndex) == '#') {   //下一个节点是#

                if (stack.empty()) {
                    return false;
                }
                stack.pop();

            } else {    //下一个节点是数字

                if (stack.empty()) {
                    return false;
                }

                num = nextCommaIndex == -1 ?
                        Integer.parseInt(preorder.substring(startIndex)) :
                        Integer.parseInt(preorder.substring(startIndex, nextCommaIndex));
                stack.pop();
                stack.push(num);
                stack.push(num);
            }

        } while (nextCommaIndex != -1);

        return stack.empty();
    }

    private int findNextIndex(char ch, int startIndex, String string) {
        int index = -1;

        for (int i = startIndex; i < string.length(); i++) {
            if (string.charAt(i) == ch) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Sol0331 sol0331 = new Sol0331();
        String[] tests = {
                "9,3,4,#,#,1,#,#,2,#,6,#,#",
                "1,#",
                "9,#,#,1"
        };


        for (String test : tests) {
            System.out.println(sol0331.isValidSerialization(test));
        }
    }
}
