package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Sol0042 {
//    static public int trap(int[] height) {
//        int res = 0;
//        for (int i = 1; i < height.length - 1; i++) {
//            int left = i - 1, right = i + 1;
//            int leftMax = height[left];
//            int rightMax = height[right];
//
//            while (left >= 0) {
//                if (leftMax < height[left]) {
//                    leftMax = height[left];
//                }
//                left--;
//            }
//            while (right <= height.length - 1) {
//                if (rightMax < height[right]) {
//                    rightMax = height[right];
//                }
//                right++;
//            }
//
//            if (height[i] < leftMax && height[i] < rightMax) {
//                res += Math.min(leftMax, rightMax) - height[i];
//            }
//        }
//        return res;
//    }

    static public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int current = 0; current < height.length; current++) {
            while (!stack.empty() && height[current] >= height[stack.peek()]) {
                int topIndex = stack.pop();
                if (stack.empty()) {
                    break;
                }
                int trapWidth = current - stack.peek() - 1;
                int trapHeight = Math.min(height[current], height[stack.peek()]) - height[topIndex];
                res += trapWidth * trapHeight;
            }
            stack.push(current);
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> heightArrayList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int temp = scanner.nextInt();
            if (temp == -1) {
                break;
            }
            heightArrayList.add(temp);
        }
        int[] height = new int[heightArrayList.size()];
        for (int i = 0; i < heightArrayList.size(); i++) {
            height[i] = heightArrayList.get(i);
        }
        System.out.println(trap(height));

    }
}
