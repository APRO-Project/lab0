package entities.ticket;

import entities.users.User;

import java.util.Date;

public class Ticket {
    private String address;
    private Date submissionDate;
    private String description;
    private PRIORITY priority;
    private STATUS status;
    private User customer;
    private User dispatcher;
    private User contractor;

    public void setPriority(PRIORITY priority) {
        this.priority = priority;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public void setDispatcher(User dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void setContractor(User contractor) {
        this.contractor = contractor;
    }

    public Ticket(String address, String description, User customer) {
        this.address = address;
        this.description = description;
        this.customer = customer;
        this.submissionDate = new Date();
        this.priority = PRIORITY.LOW;
        this.status = STATUS.ASSIGNED;
    }
}
