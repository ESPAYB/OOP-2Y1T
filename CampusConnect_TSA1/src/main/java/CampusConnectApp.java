import java.util.Scanner;

public class CampusConnectApp {
    private static final int REQUEST_LIMIT = 5;
    private static final int MIN_PRIORITY = 1;
    private static final int MAX_PRIORITY = 5;
    private static final int MIN_DAYS = 1;

    public static void main(String[] args) {
        String[] studentIds = new String[REQUEST_LIMIT];
        String[] studentNames = new String[REQUEST_LIMIT];
        String[] categories = new String[REQUEST_LIMIT];
        int[] priorities = new int[REQUEST_LIMIT];
        String[] concerns = new String[REQUEST_LIMIT];
        int[] estimatedDays = new int[REQUEST_LIMIT];

        Scanner input = new Scanner(System.in);
        System.out.println("CampusConnect Service Requests");

        for (int index = 0; index < REQUEST_LIMIT; index++) {
            System.out.println("\nRequest " + (index + 1) + " of " + REQUEST_LIMIT);
            studentIds[index] = readRequiredText(input, "Student ID: ");
            studentNames[index] = readRequiredText(input, "Student name: ");
            categories[index] = readCategory(input);
            priorities[index] = readPriority(input);
            concerns[index] = readRequiredText(input, "Short concern: ");
            estimatedDays[index] = estimateDays(categories[index], priorities[index]);

            printTicket(index + 1, studentIds[index], studentNames[index],
                    categories[index], priorities[index], concerns[index], estimatedDays[index]);
        }

        printSummary(studentIds, studentNames, categories, priorities, estimatedDays);
        input.close();
    }

    private static String readRequiredText(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = input.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field is required. Please try again.");
        }
    }

    private static String readCategory(Scanner input) {
        while (true) {
            System.out.print("Category (ENROLLMENT, DOCUMENT, PAYMENT, ADVISING): ");
            String category = input.nextLine().trim().toUpperCase();
            if (validateCategory(category)) {
                return category;
            }
            System.out.println("Choose ENROLLMENT, DOCUMENT, PAYMENT, or ADVISING.");
        }
    }

    private static boolean validateCategory(String category) {
        switch (category) {
            case "ENROLLMENT":
            case "DOCUMENT":
            case "PAYMENT":
            case "ADVISING":
                return true;
            default:
                return false;
        }
    }

    private static int readPriority(Scanner input) {
        while (true) {
            System.out.print("Priority (1-5): ");
            String text = input.nextLine().trim();
            // A single digit in the allowed range cannot overflow or cause a number-conversion error.
            if (text.length() == 1 && text.charAt(0) >= '0' + MIN_PRIORITY
                    && text.charAt(0) <= '0' + MAX_PRIORITY) {
                return text.charAt(0) - '0';
            }
            System.out.println("Enter a whole number from 1 to 5.");
        }
    }

    private static int estimateDays(String category, int priority) {
        int days;
        switch (category) {
            case "ENROLLMENT":
                days = 3;
                break;
            case "DOCUMENT":
                days = 2;
                break;
            case "PAYMENT":
                days = 1;
                break;
            case "ADVISING":
                days = 4;
                break;
            default:
                // readCategory already accepts only the four listed categories.
                days = MIN_DAYS;
                break;
        }
        // Urgent requests save one day, while the minimum remains one working day.
        if (priority == MAX_PRIORITY && days > MIN_DAYS) {
            days--;
        }
        return days;
    }

    private static void printTicket(int number, String studentId, String studentName,
                                    String category, int priority, String concern, int days) {
        System.out.println("--- Ticket " + number + " ---");
        System.out.println("Student ID: " + studentId);
        System.out.println("Student name: " + studentName);
        System.out.println("Category: " + category);
        System.out.println("Priority: " + priority);
        System.out.println("Concern: " + concern);
        System.out.println("Estimated completion: " + days + " working day(s)");
    }

    private static void printSummary(String[] studentIds, String[] studentNames,
                                     String[] categories, int[] priorities, int[] estimatedDays) {
        int enrollmentCount = 0;
        int documentCount = 0;
        int paymentCount = 0;
        int advisingCount = 0;
        int totalDays = 0;
        int highestIndex = 0;

        for (int index = 0; index < studentIds.length; index++) {
            switch (categories[index]) {
                case "ENROLLMENT":
                    enrollmentCount++;
                    break;
                case "DOCUMENT":
                    documentCount++;
                    break;
                case "PAYMENT":
                    paymentCount++;
                    break;
                case "ADVISING":
                    advisingCount++;
                    break;
                default:
                    // Every stored category came from readCategory.
                    break;
            }
            totalDays += estimatedDays[index];
            // Keeping the first match makes a highest-priority tie predictable.
            if (priorities[index] > priorities[highestIndex]) {
                highestIndex = index;
            }
        }

        double averageDays = (double) totalDays / studentIds.length;
        System.out.println("\n--- Summary ---");
        System.out.println("ENROLLMENT: " + enrollmentCount);
        System.out.println("DOCUMENT: " + documentCount);
        System.out.println("PAYMENT: " + paymentCount);
        System.out.println("ADVISING: " + advisingCount);
        System.out.println("Highest priority: Ticket " + (highestIndex + 1)
                + " - " + studentNames[highestIndex] + " (" + studentIds[highestIndex]
                + "), priority " + priorities[highestIndex]);
        System.out.printf("Average estimated days: %.2f%n", averageDays);
    }
}
