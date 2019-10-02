package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Sol0496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(nums2[i]);
            } else {
                hashMap.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = hashMap.getOrDefault(nums1[i], -1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] testNums1s = {
                {4, 1, 2},
                {2, 4}
        };
        int[][] testNums2s = {
                {1, 3, 4, 2},
                {1, 2, 3, 4}
        };

        Sol0496 sol0496 = new Sol0496();

        for (int i = 0; i < testNums1s.length; i++) {
            System.out.println(Arrays.toString(sol0496.nextGreaterElement(testNums1s[i], testNums2s[i])));
        }
    }
}
