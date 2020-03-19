package entities.ticket;

import database.DatabaseManager;
import entities.users.User;
import entities.users.UserType;
import org.sqlite.SQLite;

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

    public Ticket(long id, String address, String description, User customer) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.customer = customer;
        this.submissionDate = new Date();
        this.priority = null;
        this.status = Status.AWAITING;
    }

    private Ticket(long id, String address, String submissionDate, String description, Priority priority, Status status,
                   User customer, User dispatcher, User contractor) throws ParseException {
        if(customer.getUserType() != UserType.CUSTOMER) {
            throw new IllegalArgumentException("Customer User has to have a UserType of CUSTOMER");
        }
        if(dispatcher.getUserType() != UserType.DISPATCHER) {
            throw new IllegalArgumentException("Customer User has to have a UserType of DISPATCHER");
        }
        if(contractor.getUserType() != UserType.CONTRACTOR) {
            throw new IllegalArgumentException("Customer User has to have a UserType of CONTRACTOR");
        }

        this.id = id;
        this.address = address;
        this.submissionDate = DatabaseManager.DATE_FORMAT.parse(submissionDate);
        this.description = description;
        this.priority = priority;
        this.status = status;
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

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setDispatcher(User dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void setContractor(User contractor) {
        this.contractor = contractor;
    }

    public static HashMap<Long, Ticket> getAllTickets(Connection connection) throws SQLException, ParseException {
        HashMap<Long, Ticket> result = new HashMap<>();
        String sql = """
                SELECT tickets.id as "tickets.id", address, submission_date, description, priority, status,
                       customer.id as "customer.id", customer.first_name as "customer.first_name",
                       customer.last_name as "customer.last_name", customer.username as "customer.username",
                       customer.user_type as "customer.user_type",
                       dispatcher.id as "dispatcher.id", dispatcher.first_name as "dispatcher.first_name",
                       dispatcher.last_name as "dispatcher.last_name", dispatcher.username as "dispatcher.username",
                       dispatcher.user_type as "dispatcher.user_type",
                       contractor.id as "contractor.id", contractor.first_name as "contractor.first_name",
                       contractor.last_name as "contractor.last_name", contractor.username as "contractor.username",
                       contractor.user_type as "contractor.user_type"
                FROM tickets
                JOIN users customer ON tickets.customer = customer.id
                JOIN users dispatcher ON tickets.dispatcher = dispatcher.id
                JOIN users contractor ON tickets.contractor = contractor.id
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Ticket ticket = new Ticket(
                    resultSet.getLong("tickets.id"),
                    resultSet.getString("address"),
                    resultSet.getString("submission_date"),
                    resultSet.getString("description"),
                    Priority.fromInt(resultSet.getInt("priority")),
                    Status.fromInt(resultSet.getInt("status")),
                    User.fromSqlResult(resultSet, "customer"),
                    User.fromSqlResult(resultSet, "dispatcher"),
                    User.fromSqlResult(resultSet, "contractor")
            );

            result.put(resultSet.getLong("tickets.id"), ticket);
        }


        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", submissionDate=" + submissionDate +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", customer=" + customer +
                ", dispatcher=" + dispatcher +
                ", contractor=" + contractor +
                '}';
    }
}
