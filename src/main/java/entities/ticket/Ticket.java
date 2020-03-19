package entities.ticket;

import entities.users.User;

import java.util.Date;

public class Ticket {
    private String address;
    private Date submissionDate;
    private String description;
    private Priority priority;
    private Status status;
    private int customer;
    private int dispatcher;
    private int contractor;

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDispatcher(int dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void setContractor(int contractor) {
        this.contractor = contractor;
    }

    public Ticket(String address, String description, int customer) {
        this.address = address;
        this.description = description;
        this.customer = customer;
        this.submissionDate = new Date();
        this.priority = null;
        this.status = Status.AWAITING;
    }
}
