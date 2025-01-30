import java.util.Stack;

public class MinStack {
    //Design a stack class that supports the push, pop, top, and getMin operations.
    //
    //MinStack() initializes the stack object.
    //void push(int val) pushes the element val onto the stack.
    //void pop() removes the element on the top of the stack.
    //int top() gets the top element of the stack.
    //int getMin() retrieves the minimum element in the stack.
    //Each function should run in O(1) time.

    // Not necessary to implement a stack using other data structures

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (val <= minStack.peek() || minStack.isEmpty()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int i = stack.pop();
        if (minStack.peek() == i) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
