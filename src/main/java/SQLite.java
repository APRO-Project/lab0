import java.sql.*;

public class SQLite {
    private static void buildTables(){
        String url = "jdbc:sqlite:Database.db";

        // SQL statement for creating a new table
        String sql0 = "create table IF NOT EXISTS users\n" +
                "(\n" +
                "    id         INTEGER not null\n" +
                "        primary key autoincrement\n" +
                "        unique,\n" +
                "    first_name TEXT    not null,\n" +
                "    last_name  TEXT    not null,\n" +
                "    user_name  TEXT    not null\n" +
                "        unique,\n" +
                "    user_type  INTEGER not null\n" +
                ");";

        String sql1 = "create table IF NOT EXISTS tickets\n" +
                "(\n" +
                "    id              INTEGER not null\n" +
                "        primary key autoincrement\n" +
                "        unique,\n" +
                "    address         TEXT    not null,\n" +
                "    submission_date TEXT    not null,\n" +
                "    description     TEXT    not null,\n" +
                "    priority        INTEGER,\n" +
                "    status          INTEGER not null,\n" +
                "    customer        INTEGER not null\n" +
                "        references users,\n" +
                "    dispatcher      INTEGER\n" +
                "        references users,\n" +
                "    contractor      INTEGER\n" +
                "        references users\n" +
                ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql0);
            stmt.execute(sql1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        buildTables();

    }
}