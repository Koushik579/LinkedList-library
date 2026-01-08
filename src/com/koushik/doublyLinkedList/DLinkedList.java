package com.koushik.doublyLinkedList;

/**
 *
 * @author Koushik
 */
public class DLinkedList<T> {

    public DNode head;
    public DNode tail;

    public void insert(T data) {
        DNode<T> node = new DNode<>();
        node.data = data;
        node.next = null;
        node.pre = null;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            DNode tempnode = head;
            while (tempnode.next != null) {
                tempnode = tempnode.next;
            }
            tempnode.next = node;
            node.pre = tempnode;
            tail = node;
        }
    }

    public String show() {
        StringBuilder sb = new StringBuilder("[ ");

        DNode tempnode = head;
        while (tempnode != null) {
            sb.append(tempnode.data);
            if (tempnode.next != null) {
                sb.append(" , ");
            }
            tempnode = tempnode.next;
        }

        sb.append(" ]");
        return sb.toString();
    }

    public int size() {
        int count = 0;
        DNode<T> tempnode = head;
        while (tempnode != null) {
            count++;
            tempnode = tempnode.next;
        }
        return count;
    }

    public void insertStart(T data) {
        DNode<T> node = new DNode<>();
        node.data = data;
        head.pre = node;
        node.next = head;
        node.pre = null;
        head = node;
    }

    public void insertAt(int index, T data) {
        DNode<T> node = new DNode<>();
        node.data = data;
        if (index > size() - 1) {
            throw new IndexOutOfBoundsException("Illegal Index");
        } else if (index == 0) {
            throw new IllegalArgumentException("Use insertStart() for index '0'");
        } else {
            DNode<T> tempnode = head;
            int count = 0;
            while (tempnode.next != null) {

                if (count == index - 1) {
                    node.next = tempnode.next;
                    tempnode.next = node;
                }
                if (count == index + 1) {
                    node.pre = tempnode.pre;
                    tempnode.pre = node;
                }
                tempnode = tempnode.next;
                count++;
            }

        }
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

    public boolean isPresent(int data) {
        DNode tempnode = head;
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

    public int getData(int index) {
        int count = 0;
        int data = 0;
        if (index > size() - 1) {
            throw new IndexOutOfBoundsException("Index not present in the list");
        } else {
            DNode tempnode = head;
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

    public String reverse() {
        StringBuilder sb = new StringBuilder("[ ");

        DNode tempnode = tail;
        while (tempnode != null) {
            sb.append(tempnode.data);
            if (tempnode.pre != null) {
                sb.append(" , ");
            }
            tempnode = tempnode.pre;
        }

        sb.append(" ]");
        return sb.toString();
    }
}
