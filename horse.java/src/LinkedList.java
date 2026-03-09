//Hi this is Owen. Again. Nice to see you! How's your day? I hope you're doing well. I just wanted to share a simple implementation of a doubly-linked list in Java. This code allows you to create a linked list by entering values from the keyboard, and then it prints the contents of the list both from head-to-tail and tail-to-head. Feel free to try it out and let me know if you have any questions or need further assistance!

import java.util.Scanner;

/*
 * Simple doubly-linked list implementation without using java.util.LinkedList.
 * Nodes are represented by the Bucket class which holds a String payload.
 *
 * The program builds a list by reading values from the keyboard until the
 * user indicates they are finished.  It then prints the contents of the list
 * from head-to-tail and again from tail-to-head.
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Bucket head = null;   // first element
        Bucket tail = null;   // last element

        System.out.println("Enter items to add to the linked list.");
        System.out.println("Leave the input blank to finish (or type 'done').");
        while (true) {
            System.out.print("Data: ");
            String value = in.nextLine();
            if (value == null || value.trim().isEmpty() || value.equalsIgnoreCase("done")) {
                break;
            }
            Bucket node = new Bucket(value);
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

        if (head == null) {
            System.out.println("No items were added.");
        } else {
            System.out.println("\nList from front to back:");
            printForward(head);
            System.out.println("\nList from back to front:");
            printBackward(tail);
        }

        in.close();
    }

    private static void printForward(Bucket head) {
        Bucket current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private static void printBackward(Bucket tail) {
        Bucket current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }
}
