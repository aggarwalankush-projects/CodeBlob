package StacksQueues;

/**
 * Represents a generic Stack
 */
public class Stack<K> {
    Node<K> top;

    K pop() {
        if (top == null)
            return null;
        Node<K> node = top;
        top = top.next;
        return node.data;
    }

    void push(K data) {
        Node<K> node = new Node<>(data);
        node.next = top;
        top = node;
    }

    boolean isEmpty() {
        return top == null;
    }

    K peek() {
        return top.data;
    }

    int size(){
        Node<K> temp=top;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    @Override
    public String toString() {
        Node<K> n=top;
        StringBuilder sb=new StringBuilder("(Top to Bottom) ");
        while(n.next!=null){
            sb.append(n.data+"->");
            n=n.next;
        }
        sb.append(n.data);
        return sb.toString();
    }
}
