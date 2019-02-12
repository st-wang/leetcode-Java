package BBLeetCode;

import java.util.Stack;

public class MinStack{

    //Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    //
    //push(x) -- Push element x onto stack.
    //pop() -- Removes the element on top of the stack.
    //top() -- Get the top element.
    //getMin() -- Retrieve the minimum element in the stack.

    //Example:
    //MinStack minStack = new MinStack();
    //minStack.push(-2);
    //minStack.push(0);
    //minStack.push(-3);
    //minStack.getMin();   --> Returns -3.
    //minStack.pop();
    //minStack.top();      --> Returns 0.
    //minStack.getMin();   --> Returns -2.

    private final int MIN = 65535;
    private Stack<Integer> minElement;
    private Stack<Integer> stack;

    MinStack() {
        this.minElement = new Stack<>();
        this.minElement.push(MIN);
        this.stack = new Stack<>();
    }

    void push(int element) {
        stack.push(element);
        if (minElement.peek() > element) {
            minElement.push(element);
        }
    }

    int pop() {
        if (minElement.peek().equals(stack.peek())) {
            minElement.pop();
        }
        return this.stack.pop();
    }

    int getMin() {
        return minElement.peek();
    }

    int top() {
        return stack.peek();
    }
}
