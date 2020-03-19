import database.DatabaseManager;
import entities.ticket.Ticket;

import java.sql.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:Database.db";
        try {
            Connection conn = DriverManager.getConnection(url);
            DatabaseManager.buildTables(conn);
            HashMap<Long, Ticket> map = Ticket.getAllTickets(conn);
            for (HashMap.Entry<Long, Ticket> entry: map.entrySet()){
                System.out.println(entry.getValue());
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }
}
