import java.sql.*;
import java.util.Scanner;

public class ProcedureCaller {

    public static void main(String[] args) {
        // At this place Database will is connected 
        try (Connection connection = ConnectionProvider.getConnection()) {
            // Connectivity is ensured 
            if (connection != null) {
                // Request input from users
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter Course ID (press Enter to display all): ");
                String courseId = scanner.nextLine().trim();  // Trim to handle empty input
                System.out.println("Enter Course Name: ");
                String courseName = scanner.nextLine();

                // procedure is called with statemtns 
                try (CallableStatement callableStatement = connection.prepareCall("{call ScheduleModulesForCourse(?, ?)}")) {
                    callableStatement.setString(1, courseId);
                    callableStatement.setString(2, courseName);

                    // Execute the procedure
                    callableStatement.execute();

                    System.out.println("Modules scheduled successfully for Course ID: " + courseId);

                    // Display all scheduled modules for the specified course or all modules if no specific course provided
                    displayScheduledModules(connection, courseId);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayScheduledModules(Connection connection, String courseId) {
        try (Statement statement = connection.createStatement()) {
            // Execute a query to fetch all scheduled modules for the specified course
            String query = "SELECT m.code AS moduleCode, c.name AS courseName FROM module m "
                    + "JOIN course c ON m.course_code = c.code "
                    + (courseId.isEmpty() ? "" : "WHERE m.course_code = '" + courseId + "'");
            ResultSet resultSet = statement.executeQuery(query);

            // Display the scheduled modules
            System.out.println("Scheduled Modules:");

            while (resultSet.next()) {
                System.out.println("-----------------------------");
                System.out.println("Module Code: " + resultSet.getString("moduleCode")
                        + ", Course Name: " + resultSet.getString("courseName"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
