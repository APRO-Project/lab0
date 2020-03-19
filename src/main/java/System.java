import entities.ticket.Ticket;
import entities.users.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class System {
    private List<Ticket> ticketList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();

    public int insertTicket(Ticket ticket) {
        this.ticketList.add(ticket);
        return ticketList.size() - 1;
    }

    public boolean updateTicket(int id, Ticket ticket) {
        try {
            this.ticketList.set(id, ticket);
            return true;
        }
        catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public int createUser(User user) {
        this.userList.add(user);
        return userList.size() - 1;
    }

    public boolean updateUser(int id, User user) {
        try {
            this.userList.set(id, user);
            return true;
        }
        catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public List<Ticket> getAllTickets() {
        return ticketList;
    }

    public Ticket getTicketById(int id) {
        return ticketList.get(id);
    }

    public List<Ticket> getTicketsSortByPriority() {
        return getTicketsSortByPriority(false);
    }

    public List<Ticket> getTicketsSortByPriority(boolean reverseOrder) {
        Comparator<Ticket> comparator = !reverseOrder ?
                Comparator.comparing(Ticket::getPriority) :
                Comparator.comparing(Ticket::getPriority).reversed();
        List<Ticket> sortedTickets = ticketList.stream()
                    .sorted(comparator)
                    .collect(Collectors.toList());
        return sortedTickets;
    }

    public List<Ticket> getTicketsSortByLocation() {
        return getTicketsSortByLocation(false);
    }

    public List<Ticket> getTicketsSortByLocation(boolean reverseOrder) {
        Comparator<Ticket> comparator = !reverseOrder ?
                Comparator.comparing(Ticket::getAddress) :
                Comparator.comparing(Ticket::getAddress).reversed();
        List<Ticket> sortedTickets = ticketList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return sortedTickets;
    }

    public List<Ticket> getTicketsForConsumer(int userId) {
        return ticketList.stream()
                .filter(ticket -> ticket.getCustomer() == userId)
                .collect(Collectors.toList());
    }

    public List<Ticket> getTicketsForDispatcher(int userId) {
        return ticketList.stream()
                .filter(ticket -> ticket.getDispatcher() == userId)
                .collect(Collectors.toList());
    }

    public List<Ticket> getTicketsForContractor(int userId) {
        return ticketList.stream()
                .filter(ticket -> ticket.getContractor() == userId)
                .collect(Collectors.toList());
    }

    public User getUserById(int id) {
        return userList.get(id);
    }

    public List<User> getAllUsers() {
        return userList;
    }
}
