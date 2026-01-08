/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koushik.doublyLinkedList;

/**
 *
 * @author Koushik
 */
public class LinkedList<T> {
    public Node head;
    public void insert(T data)
    {
        Node<T> node = new Node<>();
        node.data = data;
        node.next = null;
        node.pre = null;
        if(head == null) head =node;
        else{
            Node tempnode = head;
            while(tempnode.next != null)
            {
               tempnode = tempnode.next; 
            }
            tempnode.next = node;
            node.pre = tempnode;
        }
    }
    
    public String show() {
        StringBuilder sb = new StringBuilder("[ ");

        Node tempnode = head;
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
}
