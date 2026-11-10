import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreListAnalyzer {

    public static void main(String[] args) {

        List<Integer> scores = new ArrayList<>();

        scores.add(88);
        scores.add(72);
        scores.add(95);
        scores.add(81);
        scores.add(72);

        System.out.println("Original scores: " + scores);

        int total = 0;

        for (Integer score : scores) {
            total += score;
        }

        double average = (double) total / scores.size();

        System.out.printf("Average score: %.1f%n", average);

        Collections.sort(scores);

        System.out.println("Sorted scores: " + scores);

        int scoreToFind1 = 81;
        int index1 = Collections.binarySearch(scores, scoreToFind1);

        if (index1 >= 0) {
            System.out.println(
                    scoreToFind1 + " found at index " + index1
            );
        } else {
            System.out.println(scoreToFind1 + " - Not found");
        }

        int scoreToFind2 = 100;
        int index2 = Collections.binarySearch(scores, scoreToFind2);

        if (index2 >= 0) {
            System.out.println(
                    scoreToFind2 + " found at index " + index2
            );
        } else {
            System.out.println(scoreToFind2 + " - Not found");
        }
    }
}
