import java.sql.*;

public class SQLite {
    private static void buildTables(){
        String url = "jdbc:sqlite:Database.db";

        // SQL statement for creating a new table
        String usersSQL = """
                CREATE TABLE IF NOT EXISTS users
                (
                    id         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
                    first_name TEXT    NOT NULL,
                    last_name  TEXT    NOT NULL,
                    user_name  TEXT    NOT NULL UNIQUE,
                    user_type  INTEGER NOT NULL
                );""";

        String ticketsSQL = """
                CREATE TABLE IF NOT EXISTS tickets
                (
                    id              INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
                    address         TEXT    NOT NULL,
                    submission_date TEXT    NOT NULL,
                    description     TEXT    NOT NULL,
                    priority        INTEGER,
                    status          INTEGER NOT NULL,
                    customer        INTEGER NOT NULL REFERENCES users,
                    dispatcher      INTEGER REFERENCES users,
                    contractor      INTEGER REFERENCES users
                );""";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(usersSQL);
            stmt.execute(ticketsSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}