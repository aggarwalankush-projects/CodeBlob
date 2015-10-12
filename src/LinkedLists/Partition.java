package LinkedLists;

/**
 * Partition a linked list around a value k,
 * such that all nodes less than k come before
 * all nodes greater than or equal to k
 */
public class Partition {

    public static void main(String[] args) {
        Node<Integer> linkedList = new Node<>(10);
        linkedList.append(9);
        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(7);
        System.out.println("Input LinkedList: " + linkedList);
        Node<Integer> newList = partition(linkedList, 5);
        System.out.println("Partitioned around element 5: " + newList);
    }

    /**
     * Time Complexity: O(N)
     */
    public static Node<Integer> partition(Node<Integer> node, int k) {
        if (node == null)
            return null;

        Node<Integer> smaller = null;
        Node<Integer> larger = null;
        while (node != null) {
            Node<Integer> tempNext = node.next;
            if (node.data < k) {
                node.next = smaller;
                smaller = node;
            } else {
                node.next = larger;
                larger = node;
            }
            node = tempNext;
        }
        if (smaller == null)
            return larger;
        Node<Integer> head = smaller;
        while (smaller.next != null)
            smaller = smaller.next;
        smaller.next = larger;
        return head;
    }

}


