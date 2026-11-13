import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDatabaseApp {

    private static final String URL =
            "jdbc:mysql://localhost:3306/school_db";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static JTextField idField;
    private static JTextField nameField;
    private static JTextField programField;
    private static JTextArea resultArea;

    private static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }

    private static String validateId(String idText) {
        if (idText == null || idText.trim().isEmpty()) {
            return "Please enter a student ID.";
        }

        try {
            int id = Integer.parseInt(idText.trim());

            if (id <= 0) {
                return "Student ID must be positive.";
            }

        } catch (NumberFormatException e) {
            return "Student ID must be numeric.";
        }

        return null;
    }

    private static String validateStudentInput(
            String idText,
            String name,
            String program) {

        String idError = validateId(idText);

        if (idError != null) {
            return idError;
        }

        if (name == null || name.trim().isEmpty()) {
            return "Name cannot be empty.";
        }

        if (program == null || program.trim().isEmpty()) {
            return "Program cannot be empty.";
        }

        return null;
    }

    private static String addStudent(
            int id,
            String name,
            String program) {

        String sql = """
                INSERT INTO students (id, name, program)
                VALUES (?, ?, ?)
                """;

        try (
                Connection connection = getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, program);

            int rows = statement.executeUpdate();

            if (rows == 1) {
                return "Student saved successfully.";
            }

            return "Student was not saved.";

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                return "Duplicate ID: student already exists.";
            }

            return "Database error: " + e.getMessage();
        }
    }

    private static String findStudent(int id) {
        String sql = """
                SELECT id, name, program
                FROM students
                WHERE id = ?
                """;

        try (
                Connection connection = getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);

            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    return "Found: "
                            + result.getInt("id") + " / "
                            + result.getString("name") + " / "
                            + result.getString("program");
                }

                return "Not found.";
            }

        } catch (SQLException e) {
            return "Database error: " + e.getMessage();
        }
    }

    private static void createAndShowGUI() {
        JFrame frame =
                new JFrame("Student Database Application");

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        JPanel panel = new JPanel(
                new GridLayout(5, 2, 8, 8)
        );

        idField = new JTextField();
        nameField = new JTextField();
        programField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");

        resultArea = new JTextArea(4, 25);
        resultArea.setEditable(false);

        panel.add(new JLabel("Student ID:"));
        panel.add(idField);

        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        panel.add(new JLabel("Program:"));
        panel.add(programField);

        panel.add(addButton);
        panel.add(searchButton);

        panel.add(new JLabel("Status:"));
        panel.add(resultArea);

        addButton.addActionListener(event -> {
            String idText = idField.getText().trim();
            String name = nameField.getText().trim();
            String program = programField.getText().trim();

            String validationError =
                    validateStudentInput(
                            idText,
                            name,
                            program
                    );

            if (validationError != null) {
                resultArea.setText(validationError);
                return;
            }

            int id = Integer.parseInt(idText);

            resultArea.setText(
                    addStudent(id, name, program)
            );
        });

        searchButton.addActionListener(event -> {
            String idText = idField.getText().trim();

            String validationError =
                    validateId(idText);

            if (validationError != null) {
                resultArea.setText(validationError);
                return;
            }

            int id = Integer.parseInt(idText);

            resultArea.setText(findStudent(id));
        });

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                StudentDatabaseApp::createAndShowGUI
        );
    }
}
