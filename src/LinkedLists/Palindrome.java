package LinkedLists;

import java.util.Stack;

/**
 * Check if linked list is palindrome
 */
public class Palindrome {

    public static void main(String[] args) {
        Node<Integer> linkedList = new Node<>(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(1);
        System.out.println("Input LinkedList: " + linkedList);
        System.out.println("Is LinkedList Palindrome: " + isPalindrome(linkedList));
    }

    public static boolean isPalindrome(Node<Integer> head) {
        if (head == null)
            return false;

        Node<Integer> p1 = head;
        Node<Integer> p2 = head;
        Stack<Integer> stack = new Stack<>();

        while (p2 != null && p2.next != null) {
            stack.push(p1.data);
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if (p2 != null)
            p1 = p1.next;
        while (p1 != null) {
            if (!p1.data.equals(stack.pop()))
                return false;
            p1 = p1.next;
        }
        return true;
    }

}


