// ModuleFetcher.java

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ModuleFetcher {

    public static void main(String[] args) {
        fetchModulesWithCostGreaterThan200();
    }

    public static void fetchModulesWithCostGreaterThan200() {

        // Connect to the database
        try (Connection connection = ConnectionProvider.getConnection()) {
            // Check if the connection is successful
            if (connection != null) {
                // Execute a query to fetch modules with cost > 200
                String query = "SELECT * FROM Module WHERE cost > 200";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                        ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Process the result set
                    while (resultSet.next()) {
                        System.out.println("Module Code: " + resultSet.getString("code"));
                        System.out.println("Module Cost: " + resultSet.getDouble("cost"));
                        System.out.println();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
