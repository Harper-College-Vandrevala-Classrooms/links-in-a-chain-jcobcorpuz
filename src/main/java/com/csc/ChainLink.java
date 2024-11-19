package com.csc;

public class ChainLink {
    public String color;

    ChainLink(String color){
        this.color = color;
    }

    public String toString(){
        return "ChainLink{color='" + color + "'}";
    }
}

class Node{
    private ChainLink data;
    private Node next;

    public Node(ChainLink data){
        this.data = data;
        this.next = null;
    }

    public Node(ChainLink data, Node next){
        this.data = data;
        this.next = next;
    }

    public ChainLink getData(){
        return data;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    class SinglyLinkedList {
        private Node head;

        public SinglyLinkedList() {
            this.head = null;
        }

        public void append(ChainLink clink) {
            Node newNode = new Node(clink);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }

        public ChainLink get(int index) {
            if (index < 0) {
                return null;
            }

            Node current = head;
            int count = 0;
            while (current != null) {
                if (count == index) {
                    return current.getData();
                }
                current = current.getNext();
                count++;
            }
            return null;
        }

        public void displayList() {
            Node current = head;
            while (current != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }
        }
    }
}
