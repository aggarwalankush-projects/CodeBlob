package StacksQueues;

/**
 * Represents a generic Queue
 */
public class Queue<K> {
    Node<K> first, last;

    void enqueue(K data) {
        Node<K> node = new Node<>(data);
        if (first == null) {
            first = node;
            last = first;
        } else {
            last.next = node;
            last = node;
        }
    }

    K dequeue() {
        if (first == null)
            return null;
        Node<K> temp = first;
        first = first.next;
        return temp.data;
    }

}
