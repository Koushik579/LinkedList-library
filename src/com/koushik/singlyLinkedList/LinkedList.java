package com.koushik.singlyLinkedList;

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

    public void reverse() {
        Node<T> pre = null;
        Node<T> current = head;
        while (current != null) {
            if (current.next == null) {
                head = current;
            }
            Node next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
    }

    public void middle() {
        Node<T> tempnode1 = head;
        Node<T> tempnode2 = head;
        if (head == null) {
            throw new IllegalStateException("No data in the list");
        } else {
            while (tempnode1 != null) {
                tempnode1 = tempnode1.next;
                if (tempnode1 != null) {
                    tempnode1 = tempnode1.next;
                    tempnode2 = tempnode2.next;
                }
            }
        }
        System.out.println("Middle : " + tempnode2.data);
    }

    public void delete(int index) {
        Node tempnode = head;
        Node pre = null;
        boolean isdelete = false;
        int count = 0;
        if (index == 0) {
            if (head != null) {
                tempnode = tempnode.next;
                head = tempnode;
            } else {
                throw new IndexOutOfBoundsException("No data in the list");
            }
        } else {
            while (tempnode != null) {
                if (count == index) {
                    pre.next = tempnode.next;
                    isdelete = true;
                    return;
                }
                pre = tempnode;
                tempnode = tempnode.next;
                count++;
            }
            if (isdelete == false) {
                throw new IndexOutOfBoundsException("Index range out of the list");
            }
        }
    }

    public int getData(int index) {
        int count = 0;
        int data = 0;
        if (index > size() - 1) {
            throw new IndexOutOfBoundsException("Index not present in the list");
        } else {
            Node tempnode = head;
            while (tempnode != null) {
                if (count == index) {
                    data = (int) tempnode.data;
                    return data;
                }
                tempnode = tempnode.next;
                count++;

            }
        }
        return data;
    }

    public boolean isPresent(int data) {
        Node tempnode = head;
        boolean ispresent = false;
        while (tempnode != null) {
            if (data == (int) tempnode.data) {
                ispresent = true;
                return ispresent;
            }
            tempnode = tempnode.next;
        }
        return ispresent;
    }

    public void isEmpty() {
        boolean isempty = false;
        String msg = "'false' means the list is not empty";
        if (head == null) {
            isempty = true;
            msg = "'true' means the list is empty";
        }
        System.out.println(isempty);
        System.out.println(msg);
    }
}
