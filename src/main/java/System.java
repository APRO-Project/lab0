import entities.ticket.Priority;
import entities.ticket.Status;
import entities.ticket.Ticket;
import entities.users.User;
import entities.users.UserType;

import java.util.ArrayList;
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

    public void assignTicket(int id, int dispatcherId, int contractorId, Priority priority) {
        User dispatcher = getUserById(dispatcherId);
        User contractor = getUserById(contractorId);

        if(dispatcher.getUserType() != UserType.DISPATCHER || contractor.getUserType() != UserType.CONTRACTOR) {
            throw new IllegalArgumentException("Wrong user types");
        }

        Ticket ticket = this.getTicketById(id);
        ticket.setStatus(Status.ASSIGNED);
        ticket.setDispatcher(dispatcherId);
        ticket.setContractor(contractorId);
        ticket.setPriority(priority);

        this.ticketList.set(id, ticket);
    }

    public void completeTicket(int id) {
        getTicketById(id).setStatus(Status.COMPLETED);
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
        return ticketList.stream()
                    .sorted(comparator)
                    .collect(Collectors.toList());
    }

    public List<Ticket> getTicketsSortByLocation() {
        return getTicketsSortByLocation(false);
    }

    public List<Ticket> getTicketsSortByLocation(boolean reverseOrder) {
        Comparator<Ticket> comparator = !reverseOrder ?
                Comparator.comparing(Ticket::getAddress) :
                Comparator.comparing(Ticket::getAddress).reversed();
        return ticketList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
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
