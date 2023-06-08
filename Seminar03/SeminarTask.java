package Seminar03;

public class SeminarTask {

    private static class Node{
        int value;
        Node next;
        Node previous;
    }

    Node head;
    Node tail;


    public void Add(int value){
        Node newNode = new Node();
        newNode.value = value;

        if(head != null){
            newNode.next = head;
            head.previous = newNode;
        }
        else tail = newNode;
        head = newNode;
    }

    public void Remove(){
        if(head != null && head.next != null){
            head = head.next;
            head.previous = null;
        } 
        else{
            head = tail = null;
        }
    }
    
    public boolean Find(int value){
        Node currentNode = head;
        while (currentNode != null){
            if(currentNode.value == value) return true;
            currentNode = currentNode.next;
        }
        return false;
    } 

    public void AddEnd(int value){
        Node newNode = new Node();
        newNode.value = value;
        if(head == null)
        { 
            head = newNode;
        }
        else{
            // Node lastNode = head;
            // while(lastNode.next != null) lastNode = lastNode.next;
            // lastNode.next = newNode;
            newNode.previous = tail;
            tail.next = newNode;            
        }
        tail = newNode;
    }

    public void RemoveEnd(){
        if(head != null && head.next != null){
            // Node preLastNode = tail;
            // while(preLastNode != null){
            //     if(preLastNode.next.next == null){
            //         preLastNode.next = null;
            //         return;
            //     }
            //     preLastNode = preLastNode.next;
            tail = tail.previous;
            tail.next = null;
            }
            tail = null;
            // head = null;
        }
    }



