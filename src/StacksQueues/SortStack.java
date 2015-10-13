package StacksQueues;

/**
 * Sort a stack - Biggest on top
 */
public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(8);
        stack.push(1);
        stack.push(4);
        stack.push(6);
        System.out.println("Input Stack: " + stack);
        System.out.println("Sorted Stack: " + sortStack(stack));
    }

    /**
     * Time Complexity: O(N*N)
     * Space Complexity: O(N)
     */
    public static Stack<Integer> sortStack(Stack<Integer> inputStack) {
        if (inputStack == null)
            return null;
        Stack<Integer> sortedStack = new Stack<>();
        while (!inputStack.isEmpty()) {
            int data = inputStack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > data)
                inputStack.push(sortedStack.pop());
            sortedStack.push(data);
        }
        return sortedStack;
    }


}



