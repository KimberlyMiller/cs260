package edu.bluecc.cs260.lists;

import java.sql.SQLOutput;

public class LinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println(list.size());
        for (int i = 0; i < 3; i++)
            list.add("Gerald");
        System.out.println(list.size());
        System.out.println("Done");
    }

    private Node first; // these are default to null
    private Node last; // these are default to null
    private int size = 0;

    /**
     *
     * Appends the specified element to the end of the list
     *
     * implements APPEND(v) in ADT LIST
     * @param value value to be appended to this list
     */
    public boolean add(String value) {
        // create new node
        Node node = new Node(value);
        if (first == null)
            first =  node;
        else
            last.setNext(node);
        last =  node;
        size++;
        return true;
    }

    public int size() {
        return size;
    }
}
