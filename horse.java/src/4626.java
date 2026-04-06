//made by Owen Nielsen, enjoy it or die
//again.

/*
 * Doubly-linked list implementation that supports both stack and queue operations.
 * Nodes are represented by the Bucket class which holds a String payload.
 * Added debug print statements controlled by DEBUG toggle for troubleshooting.
 */
class LinkedList {
    // Debugging toggle: set to true to enable debug print statements, false to disable
    private static final boolean DEBUG = true;
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
        if (DEBUG) {
            System.out.println("DEBUG: LinkedList constructor called. Initial state: head=null, tail=null");
        }
    }

    // Check if the list is empty
    public boolean isEmpty() {
        boolean empty = head == null;
        if (DEBUG) {
            System.out.println("DEBUG: isEmpty() called. List is " + (empty ? "empty" : "not empty"));
        }
        return empty;
    }

    // Stack operations: push (add to front), pop (remove from front)
    public void push(String data) {
        if (DEBUG) {
            System.out.println("DEBUG: push() called with data='" + data + "'. Current head: " + (head != null ? head.data : "null"));
        }
        Bucket node = new Bucket(data);
        if (head == null) {
            // first element
            head = tail = node;
            if (DEBUG) {
                System.out.println("DEBUG: First element added. head and tail set to new node.");
            }
        } else {
            // add to front
            node.next = head;
            head.prev = node;
            head = node;
            if (DEBUG) {
                System.out.println("DEBUG: Added to front. New head data='" + head.data + "', next='" + (head.next != null ? head.next.data : "null") + "'");
            }
        }
        if (DEBUG) {
            System.out.println("DEBUG: push() completed. List state: head='" + (head != null ? head.data : "null") + "', tail='" + (tail != null ? tail.data : "null") + "'");
        }
    }

    public String pop() {
        if (DEBUG) {
            System.out.println("DEBUG: pop() called. Current head: " + (head != null ? head.data : "null"));
        }
        if (isEmpty()) {
            if (DEBUG) {
                System.out.println("DEBUG: pop() on empty list, returning null.");
            }
            return null; // or throw exception
        }
        String data = head.data;
        if (DEBUG) {
            System.out.println("DEBUG: Removing data='" + data + "' from head.");
        }
        if (head == tail) {
            // only one element
            head = tail = null;
            if (DEBUG) {
                System.out.println("DEBUG: Only one element was present, list now empty.");
            }
        } else {
            head = head.next;
            head.prev = null;
            if (DEBUG) {
                System.out.println("DEBUG: Head moved to next element. New head data='" + (head != null ? head.data : "null") + "'");
            }
        }
        if (DEBUG) {
            System.out.println("DEBUG: pop() returning '" + data + "'. List state: head='" + (head != null ? head.data : "null") + "', tail='" + (tail != null ? tail.data : "null") + "'");
        }
        return data;
    }

    // Queue operations: enqueue (add to end), dequeue (remove from front)
    public void enqueue(String data) {
        if (DEBUG) {
            System.out.println("DEBUG: enqueue() called with data='" + data + "'. Current tail: " + (tail != null ? tail.data : "null"));
        }
        Bucket node = new Bucket(data);
        if (head == null) {
            // first element
            head = tail = node;
            if (DEBUG) {
                System.out.println("DEBUG: First element added. head and tail set to new node.");
            }
        } else {
            // append to end
            tail.next = node;
            node.prev = tail;
            tail = node;
            if (DEBUG) {
                System.out.println("DEBUG: Added to end. New tail data='" + tail.data + "', prev='" + (tail.prev != null ? tail.prev.data : "null") + "'");
            }
        }
        if (DEBUG) {
            System.out.println("DEBUG: enqueue() completed. List state: head='" + (head != null ? head.data : "null") + "', tail='" + (tail != null ? tail.data : "null") + "'");
        }
    }

    public String dequeue() {
        if (DEBUG) {
            System.out.println("DEBUG: dequeue() called. Current head: " + (head != null ? head.data : "null"));
        }
        if (isEmpty()) {
            if (DEBUG) {
                System.out.println("DEBUG: dequeue() on empty list, returning null.");
            }
            return null; // or throw exception
        }
        String data = head.data;
        if (DEBUG) {
            System.out.println("DEBUG: Removing data='" + data + "' from head.");
        }
        if (head == tail) {
            // only one element
            head = tail = null;
            if (DEBUG) {
                System.out.println("DEBUG: Only one element was present, list now empty.");
            }
        } else {
            head = head.next;
            head.prev = null;
            if (DEBUG) {
                System.out.println("DEBUG: Head moved to next element. New head data='" + (head != null ? head.data : "null") + "'");
            }
        }
        if (DEBUG) {
            System.out.println("DEBUG: dequeue() returning '" + data + "'. List state: head='" + (head != null ? head.data : "null") + "', tail='" + (tail != null ? tail.data : "null") + "'");
        }
        return data;
    }

    // Utility method to print the list from front to back
    public void printForward() {
        if (DEBUG) {
            System.out.println("DEBUG: printForward() called. Traversing from head to tail.");
        }
        Bucket current = head;
        int count = 0;
        while (current != null) {
            System.out.println(current.data);
            if (DEBUG) {
                System.out.println("DEBUG: Printed element " + (++count) + ": '" + current.data + "', next='" + (current.next != null ? current.next.data : "null") + "'");
            }
            current = current.next;
        }
        if (DEBUG) {
            System.out.println("DEBUG: printForward() completed. Total elements printed: " + count);
        }
    }

    // Utility method to print the list from back to front
    public void printBackward() {
        if (DEBUG) {
            System.out.println("DEBUG: printBackward() called. Traversing from tail to head.");
        }
        Bucket current = tail;
        int count = 0;
        while (current != null) {
            System.out.println(current.data);
            if (DEBUG) {
                System.out.println("DEBUG: Printed element " + (++count) + ": '" + current.data + "', prev='" + (current.prev != null ? current.prev.data : "null") + "'");
            }
            current = current.prev;
        }
        if (DEBUG) {
            System.out.println("DEBUG: printBackward() completed. Total elements printed: " + count);
        }
    }
}