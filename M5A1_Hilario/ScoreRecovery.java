public class ScoreRecovery {

    public static void evaluateScore(String scoreText)
            throws InvalidScoreException {

        int score = Integer.parseInt(scoreText);

        if (score < 0 || score > 100) {
            throw new InvalidScoreException(
                    "Score must be between 0 and 100. Received: " + score
            );
        }

        String result = score >= 75 ? "PASSED" : "FAILED";
        System.out.println("Score: " + score + " - " + result);
    }

    public static void main(String[] args) {

        String[] entries = {"85", "abc", "105"};

        for (String entry : entries) {
            System.out.println("Processing input: " + entry);

            try {
                evaluateScore(entry);

            } catch (NumberFormatException e) {
                System.out.println(
                        "Recovery: nonnumeric input is not a valid score."
                );

            } catch (InvalidScoreException e) {
                System.out.println("Recovery: " + e.getMessage());

            } finally {
                System.out.println("Validation attempt completed.");
            }

            System.out.println();
        }
    }
}
