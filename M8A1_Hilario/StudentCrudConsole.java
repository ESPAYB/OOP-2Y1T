import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCrudConsole {

    private static final String URL =
            "jdbc:mysql://localhost:3306/school_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static int addStudent(
            int id,
            String name,
            String program) throws SQLException {

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

            return statement.executeUpdate();
        }
    }

    public static void findStudent(int id) throws SQLException {
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
                    System.out.println(
                            "Found: "
                                    + result.getInt("id") + " / "
                                    + result.getString("name") + " / "
                                    + result.getString("program")
                    );
                } else {
                    System.out.println("Not found");
                }
            }
        }
    }

    public static int updateProgram(
            int id,
            String newProgram) throws SQLException {

        String sql = """
                UPDATE students
                SET program = ?
                WHERE id = ?
                """;

        try (
                Connection connection = getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {
            statement.setString(1, newProgram);
            statement.setInt(2, id);

            return statement.executeUpdate();
        }
    }

    public static int deleteStudent(int id) throws SQLException {
        String sql = """
                DELETE FROM students
                WHERE id = ?
                """;

        try (
                Connection connection = getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);

            return statement.executeUpdate();
        }
    }

    public static void main(String[] args) {
        int studentId = 108;

        try {
            // Initial cleanup prevents duplicate-ID failure during reruns.
            deleteStudent(studentId);

            int inserted = addStudent(
                    studentId,
                    "Ana Cruz",
                    "BSIT"
            );
            System.out.println("Add returned: " + inserted + " row");

            findStudent(studentId);

            int updated = updateProgram(studentId, "BSCS");
            System.out.println("Update returned: " + updated + " row");

            findStudent(studentId);

            int deleted = deleteStudent(studentId);
            System.out.println("Delete returned: " + deleted + " row");

            findStudent(studentId);

        } catch (SQLException e) {
            System.out.println(
                    "Database error: " + e.getMessage()
            );
        }
    }
}
