package stack;

import java.util.Arrays;
import java.util.Stack;

public class Sol0503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();

        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }


        stack.push(nums[maxIndex]);
        res[maxIndex] = -1;


        int index = maxIndex - 1;
        while (true) {
            if (index < 0) {
                index = nums.length - 1;
            }
            if (index == maxIndex) {
                break;
            }

            if (!stack.isEmpty() && nums[index] < stack.peek()) {
                res[index] = stack.peek();
            } else {
                while (!stack.isEmpty() && nums[index] >= stack.peek()) {
                    stack.pop();
                }
                res[index] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(nums[index]);
            index--;
        }

        return res;
    }

    public static void main(String[] args) {
        Sol0503 sol0503 = new Sol0503();

        int[][] testNums = {
                {1, 3, 4, 5, 2, 5, 3, 2, 1},
                {1},
                {},
                {1, 2, 1}
        };

        for (int[] testNum : testNums) {
            System.out.println(Arrays.toString(sol0503.nextGreaterElements(testNum)));
        }
    }
}
