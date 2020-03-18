package entities.ticket;

import java.util.Date;

public class Ticket {
    private String address;
    private Date submissionDate;
    private String description;
    private PriorityENUM priority;
    private StatusENUM status;
    private int customer;
    private int dispatcher;
    private int contractor;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriorityENUM getPriority() {
        return priority;
    }

    public void setPriority(PriorityENUM priority) {
        this.priority = priority;
    }

    public StatusENUM getStatus() {
        return status;
    }

    public void setStatus(StatusENUM status) {
        this.status = status;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(int dispatcher) {
        this.dispatcher = dispatcher;
    }

    public int getContractor() {
        return contractor;
    }

    public void setContractor(int contractor) {
        this.contractor = contractor;
    }
}
