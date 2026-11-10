import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {

    public static void main(String[] args) {

        Map<String, String> students = new HashMap<>();

        students.put("2026-001", "Ana Cruz");
        students.put("2026-002", "Ben Lim");
        students.put("2026-003", "Cara Reyes");

        String duplicateId = "2026-002";
        String duplicateName = "Daniel Tan";

        if (students.containsKey(duplicateId)) {
            System.out.println(
                    "Duplicate rejected: " + duplicateId
                            + " already belongs to " + students.get(duplicateId)
            );
        } else {
            students.put(duplicateId, duplicateName);
        }

        String searchId1 = "2026-003";

        if (students.containsKey(searchId1)) {
            System.out.println(
                    "Search result for " + searchId1 + ": "
                            + students.get(searchId1)
            );
        } else {
            System.out.println("Student not found");
        }

        String searchId2 = "2026-999";

        if (students.containsKey(searchId2)) {
            System.out.println(
                    "Search result for " + searchId2 + ": "
                            + students.get(searchId2)
            );
        } else {
            System.out.println(
                    "Search result for " + searchId2 + ": Student not found"
            );
        }

        System.out.println("\nAccepted student records:");

        for (Map.Entry<String, String> entry : students.entrySet()) {
            System.out.println(
                    entry.getKey() + " - " + entry.getValue()
            );
        }
    }
}
