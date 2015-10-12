package LinkedLists;

/**
 * Find the node at the beginning of the loop in a
 * circular linked list
 */
public class LoopStart {

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(9);
        Node<Integer> n3 = new Node<>(7);
        Node<Integer> n4 = new Node<>(11);
        Node<Integer> n5 = new Node<>(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;
        System.out.println("Input LinkedList: 10->9->(7)->11->4->goes back to (7)");
        loopStart(n1);
    }

    public static void loopStart(Node<Integer> head) {
        if (head == null)
            return;

        Node<Integer> p1 = head;
        Node<Integer> p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2)
                break;
        }
        if (p2 == null || p2.next == null)
            System.out.println("No Loops found");
        p1 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println("Start of Loop: " + p1.data);

    }

}


