package LinkedLists;

/**
 * Delete a node from a singly linked list, given only access to that node
 */
public class DeleteNode {

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(9);
        Node<Integer> n3 = new Node<>(7);
        Node<Integer> n4 = new Node<>(11);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        System.out.println("Input LinkedList: " + n1);
        deleteNode(n3);
        System.out.println("After deletion of 3rd node: " + n1);
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static void deleteNode(Node<Integer> node) {
        if (node == null || node.next==null)
            return;

        node.data=node.next.data;
        node.next=node.next.next;
    }

}


