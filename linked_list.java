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
        Node currNode = list.head, prev = null;

        //Case 1: key is at the head
        if( currNode.data == key){
            list.head = currNode.next;
            return list;
        }

        //Case 2: Anywhere else
        while(currNode != null && currNode.data != key){
            prev = currNode;
            currNode = currNode.next;
        }

        //if a key was found currNode !=null
        if(currNode != null){
            prev = currNode.next;
            return list;
        }
        //Case 3: key was not present
        if(currNode == null){
            System.out.println("Key was not found");
        }
        return list;
        
    }

    public static LinkedList deleteAtPosition(LinkedList list, int position){
        Node currNode = list.head, prev = null;

        //Case 1: if position is 0
        if(position == 0){
            list.head = currNode.next;
            return list;
        }

        //Case 2:position is anywhere else
        int counter = 0;
        while(currNode != null && counter != position){
            prev = currNode;
            currNode = currNode.next;
            counter++;
        }

        //position was found, currNode should not be null
        if(currNode != null){
            prev.next = currNode.next;
            return list;
        }
        //else position was greater than list size
        else{
            System.out.println("Position out of bounds");
        }
        return list;
    }
    public static LinkedList deleteMiddleNode(LinkedList list, Node k){
        while(k.next != null){
            k.data = k.next.data;
            k = k.next;
        }
        return list;
    }
    public static LinkedList partition(LinkedList list, int part){
        LinkedList newlist = new LinkedList();
        Node head = newlist.head;
        Node tail = newlist.head;
        Node temp = list.head;

        while(temp != null){
            if(temp.data < part){
                Node k = new Node(temp.data);
                k.next = head;
                head = k;
            }
            else if(temp.data <= part){
                Node k = new Node(temp.data);
                tail.next = k;
                tail = k;
            }
        }
        

    }


}