package LinkedLists;

/**
 * Merge 2 sorted Linked list into single sorted linked list
 */
public class Merge {

    public static void main(String[] args) {
        Node<Integer> linkedList1 = new Node<>(1);
        linkedList1.append(4);
        linkedList1.append(9);
        Node<Integer> linkedList2 = new Node<>(5);
        linkedList2.append(7);
        linkedList2.append(10);
        System.out.println("LinkedList 1: " + linkedList1);
        System.out.println("LinkedList 2: " + linkedList2);
        System.out.println("Merged LinkedList: " + merge(linkedList1, linkedList2));
    }

    /**
     * Time Complexity: O(n)
     */
    public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {

        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Node<Integer> p1 = head1;
        Node<Integer> p2 = head2;
        Node<Integer> fakeHead = new Node<>(0);
        Node<Integer> p = fakeHead;
        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null)
            p.next = p1;
        if (p2 != null)
            p.next = p2;
        return fakeHead.next;

    }

}


