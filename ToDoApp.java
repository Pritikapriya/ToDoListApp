import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String name;

    private boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }1

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        String status = completed ? "[X]" : "[ ]";
        return status + " " + name;
    }
}

public class ToDoApp {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    public void viewTasks() {
        System.out.println("To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void markTaskCompleted() {
        viewTasks();
        System.out.print("Enter the number of the task to mark as completed (or 0 to cancel): ");
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= tasks.size()) {
            Task task = tasks.get(choice - 1);
            task.markCompleted();
            System.out.println("Task marked as completed: " + task.getName());
        } else if (choice != 0) {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) {
        ToDoApp toDoApp = new ToDoApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("To-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    toDoApp.addTask();
                    break;
                case 2:
                    toDoApp.viewTasks();
                    break;
                case 3:
                    toDoApp.markTaskCompleted();
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
