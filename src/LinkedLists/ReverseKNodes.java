package LinkedLists;

/**
 * Reverse every K nodes in a linked list
 */
public class ReverseKNodes {

    public static void main(String[] args) {
        Node<Integer> linkedList = new Node<>(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        System.out.println("Input LinkedList: " + linkedList);
        System.out.println("Reverse every K=3 nodes: " + reverseKList(linkedList, 3));
    }

    /**
     * Time Complexity: O(n)
     */
    public static Node<Integer> reverseKList(Node<Integer> head, int k) {
        if (head == null || head.next == null)
            return head;
        Node<Integer> current = head;
        Node<Integer> previous = null;
        int count = 0;
        while (current != null && count < k) {
            Node<Integer> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }
        if (current != null)
            head.next = reverseKList(current, k);
        return previous;
    }

}


