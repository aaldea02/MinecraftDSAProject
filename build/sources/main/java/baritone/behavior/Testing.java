package baritone.behavior;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Testing {

    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/MinecraftPathFinder?useSSL=false&serverTimezone=UTC&user=root&password=yaryar";

    public static void main(String[] args) {
        insertDummyValues();
    }

    private static void insertDummyValues() {
        String insertQuery = "INSERT INTO PathFinderResults (bellman_ford_time, dijkstra_time, x, y, z) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // Insert dummy values
            preparedStatement.setLong(1, 5000L);
            preparedStatement.setLong(2, 4000L);
            preparedStatement.setInt(3, 1);
            preparedStatement.setInt(4, 2);
            preparedStatement.setInt(5, 3);

            preparedStatement.executeUpdate();
            System.out.println("Dummy values inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
