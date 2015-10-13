package StacksQueues;

/**
 * Implement Queue using 2 stacks
 */
public class QueueUsingStack {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        int size = queue.size();
        for (int i = 0; i < size; i++)
            System.out.println(queue.dequeue());
    }
}

class MyQueue<K> {
    Stack<K> stackOld, stackNew;

    public MyQueue() {
        stackNew = new Stack<>();
        stackOld = new Stack<>();
    }

    public int size() {
        return stackNew.size() + stackOld.size();
    }

    public void enqueue(K data) {
        stackNew.push(data);
    }

    public K dequeue() {
        shiftStacks();
        return stackOld.pop();
    }

    private void shiftStacks() {
        if (stackOld.isEmpty()) {
            while (!stackNew.isEmpty())
                stackOld.push(stackNew.pop());
        }
    }
}

