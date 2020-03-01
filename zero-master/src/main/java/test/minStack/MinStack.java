package test.minStack;

import java.util.Stack;

/**
 * 设计一个最小栈，在栈的基础上添加一个getMin()方法，并且时间复杂度为o(1)
 */
public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min = Integer.MAX_VALUE;

    private int pop() {
        int result = stack.pop();
        if (result == min) {
            minStack.pop();
            min = minStack.peek();
        }
        return result;
    }

    private void push(int i) {
        stack.push(i);
        if (i <= min) {
            min = i;
            minStack.push(i);
        }
    }

    /**
     * @return
     */
    private int getMin() {
        return min;
    }
}
