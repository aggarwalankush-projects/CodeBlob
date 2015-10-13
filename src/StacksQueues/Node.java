package StacksQueues;

/**
 * Represents a generic node for Stack or Queue
 */
public class Node<K> {
    K data;
    Node<K> next;

    Node(K data) {
        this.data = data;
    }
}
