package RecursionDP;

/**
 * Implement Queue using 2 stacks
 */
public class StairsCountWays {

    public static void main(String[] args) {
        StacksQueues.MyQueue<Integer> queue = new StacksQueues.MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        int size = queue.size();
        for (int i = 0; i < size; i++)
            System.out.println(queue.dequeue());
    }
}

