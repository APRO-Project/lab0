import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:Database.db";
        try {
            Connection databaseConnection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
