package LinkedLists;

/**
 * Find middle of a linked list
 */
public class MiddleNode {

    public static void main(String[] args) {
        Node<Integer> linkedList = new Node<>(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        System.out.println("Input LinkedList: " + linkedList);
        System.out.println("Middle element: " + findMiddle(linkedList).data);
    }

    /**
     * Time Complexity: O(n)
     */
    public static Node<Integer> findMiddle(Node<Integer> head) {
        if (head == null || head.next == null)
            return head;
        Node<Integer> p1 = head;
        Node<Integer> p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

}


