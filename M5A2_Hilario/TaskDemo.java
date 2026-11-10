package campus.tasks;

public class TaskDemo {

    public static void main(String[] args) {

        TaskBox<String> taskName =
                new TaskBox<>("Submit Module 5 Lab");

        TaskBox<Integer> estimatedMinutes =
                new TaskBox<>(45);

        Priority priority = Priority.HIGH;

        displayTask(taskName, estimatedMinutes, priority);

        // Required second test
        displayTask(taskName, estimatedMinutes, Priority.LOW);
    }

    private static void displayTask(
            TaskBox<String> taskName,
            TaskBox<Integer> estimatedMinutes,
            Priority priority) {

        String action = switch (priority) {
            case HIGH -> "DO FIRST";
            case MEDIUM -> "SCHEDULE";
            case LOW -> "OPTIONAL";
        };

        System.out.println("Task: " + taskName.getItem());
        System.out.println(
                "Estimated minutes: " + estimatedMinutes.getItem()
        );
        System.out.println("Priority: " + priority);
        System.out.println("Action: " + action);
        System.out.println();
    }
}
