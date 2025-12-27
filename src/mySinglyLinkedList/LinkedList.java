/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mySinglyLinkedList;

/**
 *
 * @author username
 */
public class LinkedList<T> {

    private Node<T> head;

    public void insert(T data) {
        Node<T> node = new Node<T>();
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

    public void insertAt(int index,T data) {
        Node<T> node = new Node<T>();
        node.data = data;
        if(index > size()-1)
        {
            throw new IndexOutOfBoundsException("Index must be within the size of the list");
        }
        else
        {
            Node<T> tempnode = head;
            int count = 0 ;
            while(tempnode.next != null)
            {
                count++;
                if(count == index-1)
                {
                    node.next = tempnode.next;
                    tempnode.next = node;
                    return;
                }
                tempnode = tempnode.next;
            }
            
        }
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
