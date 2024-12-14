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

class Node<T>{
    private T data;
    private Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    public T getData(){
        return data;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    class SinglyLinkedList<T> {
        private Node<T> head;

        public SinglyLinkedList() {
            this.head = null;
        }

        public void append(T clink) {
            Node<T> newNode = new Node<>(clink);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }

        public T get(int index) {
            if (index < 0) {
                return null;
            }

            Node<T> current = head;
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
            Node<T> current = head;
            while (current != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }
        }
    }
}
