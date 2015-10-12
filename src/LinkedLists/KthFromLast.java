package LinkedLists;

/**
 * Find the kth to last element of a singly linked list
 */
public class KthFromLast {

    public static void main(String[] args) {
        Node<Integer> linkedList = new Node<>(10);
        linkedList.append(9);
        linkedList.append(5);
        linkedList.append(4);
        linkedList.append(7);
        System.out.println("Input LinkedList: " + linkedList);
        Node<Integer> result = kthFromLast(linkedList, 3);
        if (result == null)
            System.out.println("Element not Found");
        else
            System.out.println("3rd element from last: " + result.data);
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static Node<Integer> kthFromLast(Node<Integer> head, int k) {
        if (head == null || k <= 0)
            return null;

        Node<Integer> p1 = head;
        Node<Integer> p2 = head;
        for (int i = 0; i < k - 1; i++) {
            p1 = p1.next;
            if (p1 == null)
                return null;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

}


