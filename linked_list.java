import java.io.*;

public class LinkedList{
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int newData){
            data = newData;
            next = null;
        }
    }

    public static LinkedList insertion(LinkedList list,int data){
        Node new_node = new Node(data);
        new_node.next = null;

        //if the list is empty
        //set head = new_node
        if(list.head == null){
            list.head = new_node;
        }
        //else traverse the list
        else{
            Node i = list.head;
            while(i.next != null){
                i= i.next;
            }
            i.next = new_node;
        }
        return list;
    }
    public static void printList(LinkedList list){
        Node i = list.head;
        System.out.print("LinkedList: ");
        while(i != null){
            System.out.print(i.data + " ");
            i = i.next;
        }
        System.out.println("\n");
    }
    public static LinkedList delete(LinkedList list,int key){
        
    }


}