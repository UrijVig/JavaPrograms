package Seminar03;

public class HomeTask {
    private static class Node{
        int value;
        Node next;
        Node previous;
    }

    Node head;
    Node tail;

    public void revert(){
        Node newNode = new Node();
        Node tempNode = new Node();
        newNode = tempNode = head;

        head = tail;
        tail = tempNode;

        while(newNode.next != null){
            tempNode = newNode.next;
            newNode.next = newNode.previous;
            newNode.previous = tempNode;
            newNode = tempNode.previous;
        }

    }
}
