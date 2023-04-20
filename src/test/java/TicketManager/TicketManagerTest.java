package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    @Test
    public void testSortTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1,"MSK","NY",15000, 300);
        Ticket ticket2 = new Ticket(2,"SPT","NY",25000, 400);
        Ticket ticket3 = new Ticket(3,"MSK","ROV",10000, 100);
        Ticket ticket4 = new Ticket(4,"MSK","AER",17000, 350);
        Ticket ticket5 = new Ticket(5,"MSK","ROV",13000, 120);
        Ticket ticket6 = new Ticket(6,"MSK","ROV",12000, 150);
        Ticket ticket7 = new Ticket(7,"MSK","ROV",11000, 200);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket3, ticket7, ticket6, ticket5};
        Ticket[] actual = manager.findAll("MSK", "ROV");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTicketsNotFound() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1,"MSK","NY",15000, 300);
        Ticket ticket2 = new Ticket(2,"SPT","NY",25000, 400);
        Ticket ticket3 = new Ticket(3,"MSK","ROV",10000, 100);
        Ticket ticket4 = new Ticket(4,"MSK","AER",17000, 350);
        Ticket ticket5 = new Ticket(5,"MSK","ROV",13000, 120);
        Ticket ticket6 = new Ticket(6,"MSK","ROV",12000, 150);
        Ticket ticket7 = new Ticket(7,"MSK","ROV",11000, 200);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("MSK", "SPT");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOneTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1,"MSK","NY",15000, 300);
        Ticket ticket2 = new Ticket(2,"SPT","NY",25000, 400);
        Ticket ticket3 = new Ticket(3,"MSK","ROV",10000, 100);
        Ticket ticket4 = new Ticket(4,"MSK","AER",17000, 350);
        Ticket ticket5 = new Ticket(5,"MSK","ROV",13000, 120);
        Ticket ticket6 = new Ticket(6,"MSK","ROV",12000, 150);
        Ticket ticket7 = new Ticket(7,"MSK","ROV",11000, 200);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("MSK", "NY");

        Assertions.assertArrayEquals(expected, actual);
    }

}