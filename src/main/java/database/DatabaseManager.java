package database;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DatabaseManager {
    public static final SimpleDateFormat DATE_FORMAT =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void buildTables(Connection connection){
        String usersSql = """
                CREATE TABLE IF NOT EXISTS users
                (
                    id         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
                    first_name TEXT    NOT NULL,
                    last_name  TEXT    NOT NULL,
                    username  TEXT    NOT NULL UNIQUE,
                    user_type  INTEGER NOT NULL
                );""";

        String ticketsSql = """
                CREATE TABLE IF NOT EXISTS tickets
                (
                    id              INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
                    address         TEXT    NOT NULL,
                    submission_date TEXT    NOT NULL DEFAULT CURRENT_TIMESTAMP,
                    description     TEXT    NOT NULL,
                    priority        INTEGER,
                    status          INTEGER NOT NULL,
                    customer        INTEGER NOT NULL REFERENCES users,
                    dispatcher      INTEGER REFERENCES users,
                    contractor      INTEGER REFERENCES users
                );""";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(usersSql);
            stmt.execute(ticketsSql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}