import entities.ticket.Priority;
import entities.ticket.Status;
import entities.ticket.Ticket;
import entities.users.User;
import entities.users.UserType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SystemTest {
    @Test
    void shouldHaveDefaultConstructor() {
        System system = new System();
        assertEquals(0, system.getAllTickets().size());
        assertEquals(0, system.getAllUsers().size());
    }

    @Test
    void shouldInsertTicketProperly() {
        System system = new System();
        Ticket ticket = new Ticket("address", "description", 1);
        system.insertTicket(ticket);

        assertEquals(1, system.getAllTickets().size());
        assertEquals(ticket, system.getAllTickets().get(0));
    }

    @Test
    void shouldAssignTicketProperly() {
        System system = new System();

        Ticket ticket = new Ticket("address", "description", 1);
        User dispatcher = new User("kris", "walusiak", UserType.DISPATCHER);
        User contractor = new User("dominik", "zdulski", UserType.CONTRACTOR);
        final Priority priority = Priority.HIGH;

        final int idx = system.insertTicket(ticket);
        final int disId = system.createUser(dispatcher);
        final int conId = system.createUser(contractor);
        system.assignTicket(idx, disId, conId, priority);

        assertEquals(Status.ASSIGNED, ticket.getStatus());
        assertEquals(priority, ticket.getPriority());
        assertEquals(disId, ticket.getDispatcher());
        assertEquals(conId, ticket.getContractor());
    }

    @Test
    void shouldCompleteTicketProperly() {
        System system = new System();

        Ticket ticket = new Ticket("address", "description", 1);
        User dispatcher = new User("kris", "walusiak", UserType.DISPATCHER);
        User contractor = new User("dominik", "zdulski", UserType.CONTRACTOR);
        final Priority priority = Priority.HIGH;

        final int idx = system.insertTicket(ticket);
        final int disId = system.createUser(dispatcher);
        final int conId = system.createUser(contractor);
        system.assignTicket(idx, disId, conId, priority);
        system.completeTicket(idx);

        assertEquals(Status.COMPLETED, ticket.getStatus());
    }

    @Test
    void shouldCreateUserProperly() {
        System system = new System();
        User user = new User("john", "cena", UserType.CUSTOMER);

        final int idx = system.createUser(user);

        assertEquals(1, system.getAllUsers().size());
        assertEquals(user, system.getUserById(idx));
    }

    @Test
    void shouldUpdateUserProperly() {
        System system = new System();
        User user = new User("john", "cena", UserType.CUSTOMER);
        User altUser = new User("ronnie", "osullivan", UserType.CONTRACTOR);

        final int idx = system.createUser(user);
        final boolean res = system.updateUser(idx, altUser);

        assertTrue(res);
        assertEquals(altUser, system.getUserById(idx));
    }

    @Test
    void shouldNotUpdateUserWhenGivenInvalidUserId() {
        System system = new System();
        User user = new User("john", "cena", UserType.CUSTOMER);
        User altUser = new User("ronnie", "osullivan", UserType.CONTRACTOR);

        final int idx = system.createUser(user);
        final boolean res = system.updateUser(idx + 1, altUser);

        assertFalse(res);
    }
}
