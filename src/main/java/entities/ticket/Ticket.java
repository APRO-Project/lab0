package entities.ticket;

import entities.users.Contractor;
import entities.users.Customer;
import entities.users.Dispatcher;

import java.util.Date;

public class Ticket {
    private String address;
    private Date submissionDate;
    private String description;
    private PRIORITY priority;
    private STATUS status;
    private Customer customer;
    private Dispatcher dispatcher;
    private Contractor contractor;

    public void setPriority(PRIORITY priority) {
        this.priority = priority;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Ticket(String address, String description, Customer customer) {
        this.address = address;
        this.description = description;
        this.customer = customer;
        this.submissionDate = new Date();
        this.priority = PRIORITY.LOW;
        this.status = STATUS.ASSIGNED;
    }
}
