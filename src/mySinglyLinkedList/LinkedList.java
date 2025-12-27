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
    
    public void insert(T data)
    {
        Node<T> node = new Node<T>();
        node.data = data;
        node.next = null;
        
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node<T> tempnode = head;
            while(tempnode.next != null)
            {
                tempnode = tempnode.next;
            }
            tempnode.next = node;
        }
    }
    
    public void show()
    {
        Node<T> tempnode = head;
        StringBuilder sb = new StringBuilder("[ ");
        while(tempnode != null)
        {
            sb.append(tempnode.data);
            if(tempnode.next != null)sb.append(" , ");
            tempnode = tempnode.next;
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }   
}
