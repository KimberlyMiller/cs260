package edu.bluecc.cs260.lists;

public class Node {

    private String value;
    private Node next;
    private Node prev;

    public Node(String value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public String getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }
}

