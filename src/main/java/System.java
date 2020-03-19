import entities.ticket.Ticket;
import entities.users.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class System {
    private List<Ticket> ticketList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();

    public int insertTicket(Ticket ticket) {
        this.ticketList.add(ticket);
        return ticketList.size() - 1;
    }

    public boolean updateTicket() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int createUser() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean updateUser() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public List<Ticket> getAllTickets() {
        return ticketList;
    }

    public List<Ticket> getTicketsSortByPriority() {
        return getTicketsSortByPriority(false);
    }

    public List<Ticket> getTicketsSortByPriority(boolean reverseOrder) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public  List<Ticket> getTicketsSortByLocation() {
        return getTicketsSortByLocation(false);
    }

    public  List<Ticket> getTicketsSortByLocation(boolean reverseOrder) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public List<Ticket> getTicketsForUser(int userid) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
