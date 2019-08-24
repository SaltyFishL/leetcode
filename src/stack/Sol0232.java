package stack;

import java.util.Stack;

public class Sol0232 {
    class MyQueue {
        Stack<Integer> front;
        Stack<Integer> rear;

        /** Initialize your data structure here. */
        public MyQueue() {
            front = new Stack<>();
            rear = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            rear.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (empty()) {
                throw new RuntimeException("QueueEmpty");
            }

            if (front.empty()) {
                while (!rear.empty()) {
                    front.push(rear.pop());
                }
            }
            return front.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (empty()) {
                throw new RuntimeException("QueueEmpty");
            }

            if (front.empty()) {
                while (!rear.empty()) {
                    front.push(rear.pop());
                }
            }
            return front.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return front.empty() && rear.empty();
        }
    }
}
