//I'm not sure what documentation you are talking about in the assignment for this week, but the use is Owen Nielsen, this is a simple study planner that organizes tasks and how to do it is, you enter a task by pressing one, then you can view your tasks by pressing two, you can mark a task complete by pressing three, you can delete a task by pressing four, and you can save and exit by pressing five. The tasks are saved in a text file called tasks.txt and they are loaded when the program starts.
//there ya go.
//another amazing a+ file from Owen Nielsen

import java.util.*;
import java.io.*;

class Task {
    String title;
    String dueDate;
    String priority;
    boolean completed;

    public Task(String title, String dueDate, String priority) {
        this.title = title;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public String toString() {
        return title + " | Due: " + dueDate + " | Priority: " + priority + " | Completed: " + completed;
    }
}

public class StudyPlanner {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        loadTasks();

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Save and Exit");

            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1: addTask(); break;
                case 2: viewTasks(); break;
                case 3: markComplete(); break;
                case 4: deleteTask(); break;
                case 5: saveTasks(); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void addTask() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter due date: ");
        String dueDate = scanner.nextLine();

        System.out.print("Enter priority (low/medium/high): ");
        String priority = scanner.nextLine();

        tasks.add(new Task(title, dueDate, priority));
        System.out.println("Task added.");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }
    }

    static void markComplete() {
        viewTasks();
        System.out.print("Enter task number: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).completed = true;
            System.out.println("Marked as complete.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    static void deleteTask() {
        viewTasks();
        System.out.print("Enter task number: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    static void saveTasks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Task t : tasks) {
                writer.println(t.title + "," + t.dueDate + "," + t.priority + "," + t.completed);
            }
            System.out.println("Tasks saved.");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    static void loadTasks() {
        try (Scanner fileScanner = new Scanner(new File(FILE_NAME))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                Task t = new Task(parts[0], parts[1], parts[2]);
                t.completed = Boolean.parseBoolean(parts[3]);
                tasks.add(t);
            }
        } catch (IOException e) {
            // file might not exist yet, that's fine
        }
    }
}
