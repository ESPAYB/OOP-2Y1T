import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;

public class PassFailChecker {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PassFailChecker::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Pass/Fail Score Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel promptLabel = new JLabel("Enter score:");
        JTextField scoreField = new JTextField();

        JButton checkButton = new JButton("Check Result");
        JLabel resultLabel = new JLabel("Result will appear here.");

        panel.add(promptLabel);
        panel.add(scoreField);

        panel.add(checkButton);
        panel.add(resultLabel);

        checkButton.addActionListener(event -> {
            String input = scoreField.getText().trim();

            if (input.isEmpty()) {
                resultLabel.setText("Invalid score");
                return;
            }

            try {
                int score = Integer.parseInt(input);
                resultLabel.setText(evaluateScore(score));
            } catch (NumberFormatException e) {
                resultLabel.setText("Invalid score");
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static String evaluateScore(int score) {
        if (score >= 75 && score <= 100) {
            return "PASS";
        } else if (score >= 0 && score <= 74) {
            return "FAIL";
        } else {
            return "Invalid score";
        }
    }
}