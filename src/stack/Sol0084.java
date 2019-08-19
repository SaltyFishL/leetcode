package stack;

import java.util.HashSet;
import java.util.Stack;

public class Sol0084 {

    /**
     * 当输入的heights长度过多, 例如20000时, 会爆内存
     * 时间复杂度为$ O(n^2) $, 空间复杂度为$ O(n^2) $
     */
//    static public int largestRectangleArea(int[] heights) {
//        if (heights.length == 0) {
//            return 0;
//        }
//
//        int[][] min = new int[heights.length][heights.length];
//        int maxArea = heights[0];
//        for (int i = 0; i < heights.length - 1; i++) {
//            min[i][i + 1] = Math.min(heights[i], heights[i + 1]);
//            maxArea = Math.max(maxArea, Math.max(Math.max(heights[i], heights[i + 1]), min[i][i + 1] * 2));
//        }
//
//        for (int distance = 2; distance < heights.length; distance++) {
//            for (int i = 0; i < heights.length - distance; i++) {
//                min[i][i + distance] = Math.min(min[i][i + distance - 1], min[i + 1][i + distance]);
//                maxArea = Math.max(maxArea, (distance + 1) * min[i][i + distance]);
//            }
//        }
//
//        return maxArea;
//    }

    /**
     * 暴力用HashSet求解
     * @param heights
     * @return
     */
//    static public int largestRectangleArea(int[] heights) {
//        int maxArea = 0;
//        HashSet<Integer> heightSet = new HashSet<>();
//
//        for (int height : heights) {
//            heightSet.add(height);
//        }
//
//        for (Integer height : heightSet) {
//            int maxWidth = 0;
//            int width = 0;
//            for (int currentHeight : heights) {
//                if (currentHeight >= height) {
//                    width++;
//                } else {
//                    maxWidth = Math.max(maxWidth, width);
//                    width = 0;
//                }
//            }
//            maxWidth = Math.max(maxWidth, width);
//            maxArea = Math.max(maxArea, maxWidth * height);
//        }
//
//        return maxArea;
//    }

    /**
     * 利用单调栈求解
     * @param heights
     * @return
     */
    static public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int maxArea = 0;

        Stack<Integer> heightIndexStack = new Stack<>();
        heightIndexStack.push(-1);
        for (int current = 0; current < heights.length; current++) {
            while (heightIndexStack.peek() != -1 && heights[current] <= heights[heightIndexStack.peek()]) {
                int mid = heightIndexStack.pop();
                int width = current - heightIndexStack.peek() - 1;
                maxArea = Math.max(maxArea, width * heights[mid]);
            }
            heightIndexStack.push(current);
        }

        while (heightIndexStack.peek() != -1) {
            int mid = heightIndexStack.pop();
            int width = heights.length - heightIndexStack.peek() - 1;
            maxArea = Math.max(maxArea, width * heights[mid]);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {2, 1, 5, 6, 2, 3}, //10
                {2, 1, 2},  //3
                {1},    //1
                {1, 2, 3, 4},   //6
                {4, 3, 2, 1},   //6
                {2, 2, 3, 3, 1, 1, 2, 2, 4, 4}, //10
                {2, 2, 3, 3, 1, 5, 6, 4, 2},    //12
        };

        for (int[] test : tests) {
            System.out.println(largestRectangleArea(test));
        }
    }
}
