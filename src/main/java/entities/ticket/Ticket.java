package entities.ticket;

import entities.users.User;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Ticket {
    private long id;
    private String address;
    private Date submissionDate;
    private String description;
    private Priority priority;
    private Status status;
    private User customer;
    private User dispatcher;
    private User contractor;

    public Ticket(long id,
                  String address,
                  String submissionDate,
                  String description,
                  int priority,
                  int status,
                  User customer,
                  User dispatcher,
                  User contractor) throws ParseException {
        this.id = id;
        this.address = address;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.submissionDate = format.parse(submissionDate);
        this.description = description;
        this.priority = Priority.getPriority(priority);
        this.status = Status.getStatus(status);
        this.customer = customer;
        this.dispatcher = dispatcher;
        this.contractor = contractor;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDispatcher(User dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void setContractor(User contractor) {
        this.contractor = contractor;
    }

    public Ticket(long id, String address, String description, User customer) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.customer = customer;
        this.submissionDate = new Date();
        this.priority = null;
        this.status = Status.AWAITING;
    }

    public static HashMap getAllTickets(Connection connection) throws SQLException, ParseException {
        HashMap result = new HashMap<Long, Ticket>();
        String sql = """
                SELECT id, address, submission_date, description, priority, status, customer, dispatcher, contractor
                FROM tickets
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            result.put(resultSet.getLong("id"), new Ticket(
                    resultSet.getLong("id"),
                    resultSet.getString("address"),
                    resultSet.getString("submission_date"),
                    resultSet.getString("description"),
                    resultSet.getInt("priority"),
                    resultSet.getInt("status"),
                    null,
                    null,
                    null
            ));
        }
        return result;
    }
}
