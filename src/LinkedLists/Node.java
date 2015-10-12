package LinkedLists;

/**
 * Represents a generic node of Linked List
 */
public class Node<K> {
    K data;
    Node<K> next;

    Node(K data) {
        this.data = data;
    }

    void append(K d) {
        Node<K> newNode = new Node<>(d);
        Node<K> n = this;
        while (n.next != null)
            n = n.next;
        n.next = newNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node n = this;
        while (n.next != null) {
            sb.append(n.data + "->");
            n = n.next;
        }
        sb.append(n.data);
        return sb.toString();
    }
}
