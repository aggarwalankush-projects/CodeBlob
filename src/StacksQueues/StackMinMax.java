package StacksQueues;

/**
 * Design a stack which, in addition to push and pop,
 * also has a function min, max which returns the minimum and maximum element resp.
 * Push, pop, min and max should all operate in O(1) time.
 */
public class StackMinMax {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(8);
        stack.push(1);
        stack.push(4);
        stack.push(6);
        System.out.println("Input Stack: " + stack);
        System.out.println("Min: " + stack.min());
        System.out.println("Max: " + stack.max());
    }
}

class MyStack extends Stack<Integer> {

    private Stack<Integer> minStack;
    private Stack<Integer> maxStack;

    public MyStack() {
        minStack = new Stack<>();
        maxStack = new Stack<>();
    }

    @Override
    void push(Integer data) {
        if (data <= min())
            minStack.push(data);
        if (data >= max())
            maxStack.push(data);
        super.push(data);
    }

    @Override
    Integer pop() {
        int data = super.pop();
        if (data == min())
            minStack.pop();
        if (data == max())
            maxStack.pop();
        return data;
    }

    int min() {
        if (minStack.isEmpty())
            return Integer.MAX_VALUE;
        return minStack.peek();
    }

    int max() {
        if (maxStack.isEmpty())
            return Integer.MIN_VALUE;
        return maxStack.peek();
    }

}



