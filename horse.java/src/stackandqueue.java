//It's owen again. Hi
import java.util.Scanner;

/*
 * Program to demonstrate stack and queue operations using a custom LinkedList.
 * Part 1: Basic demonstration of adding to and removing from stack and queue.
 * Part 2: Real-world simulation - Queue for store line, Stack for browser history.
 */
public class stackandqueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("=== Stack and Queue Demonstration ===\n");

        // Part 1: Basic demonstration
        System.out.println("Part 1: Basic Stack and Queue Operations");
        System.out.println("Enter strings to add to both a queue and a stack.");
        System.out.println("Enter '-1' to stop input.\n");

        LinkedList queue = new LinkedList();
        LinkedList stack = new LinkedList();

        while (true) {
            System.out.print("Enter data: ");
            String input = in.nextLine();
            if (input.equals("-1")) {
                break;
            }
            queue.enqueue(input);
            stack.push(input);
        }

        System.out.println("\nRemoving from Queue (FIFO - First In, First Out):");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        System.out.println("\nRemoving from Stack (LIFO - Last In, First Out):");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        // Part 2: Real-world simulation
        System.out.println("\n\nPart 2: Real-World Simulations");

        // Queue simulation: Store line
        System.out.println("\n--- Queue Simulation: Store Checkout Line ---");
        LinkedList checkoutLine = new LinkedList();

        System.out.println("Customers arriving at checkout:");
        checkoutLine.enqueue("Customer 1 (John)");
        System.out.println("John joins the line");
        checkoutLine.enqueue("Customer 2 (Mary)");
        System.out.println("Mary joins the line");
        checkoutLine.enqueue("Customer 3 (Bob)");
        System.out.println("Bob joins the line");

        System.out.println("\nProcessing customers (serving in order):");
        while (!checkoutLine.isEmpty()) {
            String customer = checkoutLine.dequeue();
            System.out.println("Now serving: " + customer);
        }

        // Stack simulation: Browser history
        System.out.println("\n--- Stack Simulation: Browser History ---");
        LinkedList browserHistory = new LinkedList();

        System.out.println("Browsing websites:");
        browserHistory.push("google.com");
        System.out.println("Visited: google.com");
        browserHistory.push("stackoverflow.com");
        System.out.println("Visited: stackoverflow.com");
        browserHistory.push("github.com");
        System.out.println("Visited: github.com");

        System.out.println("\nUsing back button (LIFO):");
        while (!browserHistory.isEmpty()) {
            String site = browserHistory.pop();
            System.out.println("Went back to: " + site);
        }

        in.close();
    }
}