package stack;

import java.util.Stack;

public class Sol0085 {
    static public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i == 0) {
                    heights[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    heights[i][j] = matrix[i][j] == '0' ? 0 : heights[i - 1][j] + 1;
                }
            }
        }

        for (int[] height : heights) {
            maxArea = Math.max(maxArea, maxHistogramRectangle(height));
        }

        return maxArea;
    }

    static private int maxHistogramRectangle(int[] heights) {
        int maxArea = 0;
        Stack<Integer> heightsIndexStack = new Stack<>();
        heightsIndexStack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            while (heightsIndexStack.peek() != -1 && heights[i] <= heights[heightsIndexStack.peek()]) {
                int mid = heightsIndexStack.pop();
                int width = i - heightsIndexStack.peek() - 1;
                maxArea = Math.max(maxArea, heights[mid] * width);
            }
            heightsIndexStack.push(i);
        }

        while (heightsIndexStack.peek() != -1) {
            int mid = heightsIndexStack.pop();
            int width = heights.length - heightsIndexStack.peek() - 1;
            maxArea = Math.max(maxArea, heights[mid] * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalRectangle(matrix));
    }
}
