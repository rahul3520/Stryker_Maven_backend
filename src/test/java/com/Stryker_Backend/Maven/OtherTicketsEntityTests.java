package com.Stryker_Backend.Maven;

import com.Stryker_Backend.Maven.entity.dao.OtherTicketsEntity;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class OtherTicketsEntityTests {

    @Test
    public void testOtherTicketsEntity() {
        // Create a OtherTicketsEntity object
        OtherTicketsEntity ticket = new OtherTicketsEntity(
                1, "Ticket123", new Date(), new Date(), "Open"
        );

        // Test the getter methods
        assertEquals(1, ticket.getId());
        assertEquals("Ticket123", ticket.getTicketNumber());
        assertNotNull(ticket.getRequestedDate());
        assertNotNull(ticket.getReturnDate());
        assertEquals("Open", ticket.getStatus());

        // Test the setter methods
        ticket.setId(2);
        assertEquals(2, ticket.getId());

        ticket.setTicketNumber("Ticket456");
        assertEquals("Ticket456", ticket.getTicketNumber());

        Date newRequestedDate = new Date();
        ticket.setRequestedDate(newRequestedDate);
        assertEquals(newRequestedDate, ticket.getRequestedDate());

        Date newReturnDate = new Date();
        ticket.setReturnDate(newReturnDate);
        assertEquals(newReturnDate, ticket.getReturnDate());

        ticket.setStatus("Closed");
        assertEquals("Closed", ticket.getStatus());
    }
}
