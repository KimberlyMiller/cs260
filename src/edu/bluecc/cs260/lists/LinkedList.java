package edu.bluecc.cs260.lists;

import java.sql.SQLOutput;

// TODO add double linking to the mothod and then leave this comment for the instructor

public class LinkedList implements List {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list.size()); // 3
        System.out.println(list.get(2)); // C
        System.out.println(list.get(0)); // A
        System.out.println(list.get(1)); // B
    }

    public static void testMain(String[] args) {
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
        else {
            last.setNext(node);
            // node.setPrev(last); // this is the is the "old" last node  // this is double-link, and add it in the other add methods, and in the other remove methods
        }
        last =  node;
        size++;
        return true;
    }

    @Override
    public void add(int index, String val) {
        // TODO write this
    }

    /**
     * Implements the DELETE(v) operation of ADT LIST
     * Removes the first occurrence of the given value from the list, if it exists
     *
     * @param value the values to be removed
     * @return true the value was removed, false if wasn't found in the list
     */
    public boolean remove(String value) {
        Node prev = null; // TODO once double linking is set up remove this, because it can use the pointers from the Node object
        Node node = first;
        while (node != null) {
            if (node.getValue().equals(value)) {
                prev.setNext(node.getNext());
                if (prev == null) { // the value at the beginning
                    first = first.getNext();  // this will set the first to a value
                } else {
                    prev.setNext(node.getNext());
                    // node.setPrev(last); // TODO, add this, this is the is the "old" last node  // this is double-link, and add it in the other add methods, and in the other remove methods
                    // TODO handle when last note is deleted
                    //  add in something here, that will handle the variable last, it is just hanging off in space right now
                    // it is possible that the first and last thing in the list are pointing to the samething due to there being only one item in the list. You want to make sure that you handle that case (if statement) use the == equals operator
                }
                return true; // return true, if the first value in the list that matched is moved
            }
            prev = node;  // this moves the previous variable to one ahead
            node = node.getNext(); // this moves the node one up to the next node
        }
        return false;  // if it is not in the list
    }

    @Override
    public String remove(int index) {
        // TODO write this
        return null;
    }

    // DELETE(p)
    // return the value that's removed; throw an INdexOutOfBoundsException if the index is invalid
    // TODO public String remove(int index) {}

    /**
     *
     * Retrieve a value from the list at a given index
     * implements RETRIEVE(p) -> v (value) in ADT LIST
     *
     * @param index the index in the list; 0 is first index
     * @return the value at the given index location
     */
    public String get(int index) {
        if (index < 0 || index >= size)  // this checks to see if this index is out of bounds
            throw new IndexOutOfBoundsException(index + " is an invalid index");
        Node temp =  first ; // this is not a new object in memory, just a temporary pointer to be moved.
        for (int i = 0; i < index; i++)
            temp = temp.getNext(); // this keeps moving the temp pointer to the next position in the list
        return temp.getValue();
    }

    /**
     * Implements LOCATE(v) → p
     * Return the first index in the list with the given value, or -1 if it's not found
     *
     * @param val
     * @return
     */
    @Override
    public int find(String val) {
        // TODO write this
        return 0;
    }

    /**
     *
     * Implements the LOCATE(v) -> p operation of ADT LIST
     * Return the first indext in the list with the given value, or -1 if it's not found
     *
     * @param value the value to look for
     * @return the index where it was found, or -1 if not in the list
     */
    // TODO public int find(String value){
       // set a temporary pointer to the first element
        // move the pointer until we find the value

        // return -1 if not found
    //}


    public int size() {
        // TODO write this
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO write this
        return false;
    }

    @Override
    public boolean contains(String value) {
        // TODO write this
        return false;
    }

    @Override
    public void clear() {

    }
}
