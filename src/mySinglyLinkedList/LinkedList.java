package mySinglyLinkedList;

/**
 *
 * @author Koushik
 * @param <T>
 */
public class LinkedList<T> {

    private Node<T> head;

    public void insert(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node<T> tempnode = head;
            while (tempnode.next != null) {
                tempnode = tempnode.next;
            }
            tempnode.next = node;
        }
    }

    public void insertAt(int index, T data) {
        Node<T> node = new Node<>();
        node.data = data;
        if (index > size() - 1) {
            throw new IndexOutOfBoundsException("Index must be within the size of the list");
        } else if (index == 0) {
            throw new IllegalArgumentException("Use insertStart() for index '0'");
        } else {
            Node<T> tempnode = head;
            int count = 0;
            while (tempnode.next != null) {
                count++;
                if (count == index - 1) {
                    node.next = tempnode.next;
                    tempnode.next = node;
                    return;
                }
                tempnode = tempnode.next;
            }

        }
    }

    public void insertStart(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        node.next = head;
        head = node;
    }

    public void show() {
        Node<T> tempnode = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (tempnode != null) {
            sb.append(tempnode.data);
            if (tempnode.next != null) {
                sb.append(" , ");
            }
            tempnode = tempnode.next;
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    public int size() {
        int count = 0;
        Node<T> tempnode = head;
        while (tempnode != null) {
            count++;
            tempnode = tempnode.next;
        }
        return count;
    }
}
