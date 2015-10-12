package LinkedLists;

import java.util.HashSet;

/**
 * Remove duplicates from an unsorted linked list
 */
public class DuplicateRemove {

    public static void main(String[] args) {
        Node<Integer> linkedList = new Node<>(10);
        linkedList.append(9);
        linkedList.append(10);
        linkedList.append(4);
        linkedList.append(7);
        System.out.println("Input LinkedList1: " + linkedList);
        removeDup1(linkedList);
        System.out.println("After Removing Duplicates: " + linkedList);
        linkedList.append(10);
        System.out.println("Input LinkedList2: " + linkedList);
        removeDup2(linkedList);
        System.out.println("After Removing Duplicates: " + linkedList);
    }

    /**
     * Time Complexity: O(n)
     */
    public static void removeDup1(Node<Integer> n) {

        if (n == null || n.next == null)
            return;
        HashSet<Integer> set = new HashSet<>();
        Node<Integer> prev = null;
        while (n != null) {
            if (set.contains(n.data))
                prev.next = n.next;
            else {
                set.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }
    /**
     * Time Complexity: O(N*N)
     * Space Complexity: O(1)
     */
    public static void removeDup2(Node<Integer> n) {

        if (n == null || n.next == null)
            return;
        while (n != null) {
            Node<Integer> runner=n;
            while(runner.next!=null){
                if(runner.next.data.equals(n.data))
                    runner.next=runner.next.next;
                else
                    runner=runner.next;
            }
            n = n.next;
        }
    }

}


class Node<K> {
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