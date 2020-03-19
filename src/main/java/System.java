import entities.ticket.Priority;
import entities.ticket.Status;
import entities.ticket.Ticket;
import entities.users.User;
import entities.users.UserType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Main in memory data class handling all entity manipulations
 */
public class System {
    private final List<Ticket> ticketList = new ArrayList<>();
    private final List<User> userList = new ArrayList<>();

    public int insertTicket(Ticket ticket) {
        this.ticketList.add(ticket);
        return ticketList.size() - 1;
    }

    /**
     * Assigns ticket by a dispatcher to a contractor given the priority
     *
     * @param id Id of the ticket to alter
     * @param dispatcherId Id of the dispatcher handling the ticket
     * @param contractorId Id of the contractor that the ticket has been assigned to
     * @param priority Priority o the ticket
     */
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

    /**
     * Marks the ticket as completed
     *
     * @param id Id o the ticket
     */
    public void completeTicket(int id) {
        getTicketById(id).setStatus(Status.COMPLETED);
    }

    /**
     * Inserts a new {@link User} to the data set
     * @param user User to insert
     * @return id of the inserted User
     */
    public int createUser(User user) {
        this.userList.add(user);
        return userList.size() - 1;
    }

    /**
     * Updates the {@link User}
     * @param id id of the User to update
     * @param user User to update
     * @return true if the user has been updated
     */
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
        try {
            return ticketList.get(id);
        }catch (IndexOutOfBoundsException e){
            return null;
        }
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
        try {
            return userList.get(id);
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public List<User> getAllUsers() {
        return userList;
    }
}
