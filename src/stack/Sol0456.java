package stack;

import java.util.Stack;

public class Sol0456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        //for each nums[i] as "3" of "132" pattern, min[i] is the best "1" for nums[i]
        //it's obvious that min is a non-increasing array
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();
        //find "2" of "132" pattern for each "13" pair
        for (int i = nums.length - 1; i >= 1; i--) {

            if (nums[i] > min[i]) { //to ensure the legality of "1" and "3"

                //to ensure stack's values are all greater than min[i]
                //cause min is a non-increasing array, the value out of stack must be greater than min[x](x<=i)
                while (!stack.isEmpty() && stack.peek() <= min[i]) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }


            }
            //anyway, add potential "2" of "132" pattern
            if(stack.isEmpty() || stack.peek() > nums[i])
                stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Sol0456 sol0456 = new Sol0456();
        int[][] testNums = {
                {1, 2, 3, 4},
                {3, 1, 4, 2},
                {-1, 3, 2, 0},
                {3, 5, 0, 3, 4}
        };
        for (int[] testNum : testNums) {
            System.out.println(sol0456.find132pattern(testNum));

        }
    }
}
