package LinkedLists;

/**
 * Reverse a linked list
 */
public class Reverse {

    public static void main(String[] args) {
        Node<Integer> linkedList = new Node<>(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        System.out.println("Input LinkedList: " + linkedList);
        System.out.println("Reverse LinkedList: " + reverseList(linkedList));
    }

    /**
     * Time Complexity: O(n)
     */
    public static Node<Integer> reverseList(Node<Integer> head) {
        if (head == null || head.next == null)
            return head;
        Node<Integer> current = head;
        Node<Integer> previous = null;
        while (current != null) {
            Node<Integer> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

}


