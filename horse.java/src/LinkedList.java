/*
 * Doubly-linked list implementation that supports both stack and queue operations.
 * Nodes are represented by the Bucket class which holds a String payload.
 */
public class LinkedList {
    /*
     * Node container for the linked list.  It stores a value plus pointers to
     * the previous and next nodes in the list.
     */
    private static class Bucket {
        String data;
        Bucket next;
        Bucket prev;

        Bucket(String data) {
            this.data = data;
        }
    }

    private Bucket head;   // first element
    private Bucket tail;   // last element

    // Constructor
    public LinkedList() {
        head = null;
        tail = null;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Stack operations: push (add to front), pop (remove from front)
    public void push(String data) {
        Bucket node = new Bucket(data);
        if (head == null) {
            // first element
            head = tail = node;
        } else {
            // add to front
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public String pop() {
        if (isEmpty()) {
            return null; // or throw exception
        }
        String data = head.data;
        if (head == tail) {
            // only one element
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return data;
    }

    // Queue operations: enqueue (add to end), dequeue (remove from front)
    public void enqueue(String data) {
        Bucket node = new Bucket(data);
        if (head == null) {
            // first element
            head = tail = node;
        } else {
            // append to end
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            return null; // or throw exception
        }
        String data = head.data;
        if (head == tail) {
            // only one element
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return data;
    }

    // Utility method to print the list from front to back
    public void printForward() {
        Bucket current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Utility method to print the list from back to front
    public void printBackward() {
        Bucket current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }
}
