package LinkedLists;

/**
 * Two numbers are represented by two linked lists.
 * The digits are stored in reverse order,
 * add these numbers and return result as a new linked list
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        Node<Integer> number1 = new Node<>(1);
        number1.append(9);
        number1.append(5);
        Node<Integer> number2 = new Node<>(8);
        number2.append(4);
        number2.append(7);
        System.out.println("Number 1: " + number1);
        System.out.println("Number 2: " + number2);
        System.out.println("Sum: " + add(number1, number2));
    }


    public static Node<Integer> add(Node<Integer> num1, Node<Integer> num2) {
        return add(num1, num2, 0);
    }

    public static Node<Integer> add(Node<Integer> num1, Node<Integer> num2, int carry) {

        if (num1 == null && num2 == null && carry == 0)
            return null;

        int sum = carry;
        if (num1 != null)
            sum += num1.data;
        if (num2 != null)
            sum += num2.data;

        Node<Integer> result = new Node<>(sum % 10);

        if (num1 != null || num2 != null) {
            Node<Integer> node = add(num1 == null ? null : num1.next,
                    num2 == null ? null : num2.next,
                    sum >= 10 ? 1 : 0);
            result.next = node;
        }
        return result;
    }

}


