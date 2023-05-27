package com.Stryker_Backend.Maven;

import com.Stryker_Backend.Maven.entity.dao.SurgeryDetailsEntity;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SurgeryDetailsEntityTests {

    @Test
    public void testSurgeryDetailsEntity() {
        // Create a SurgeryDetailsEntity object
        SurgeryDetailsEntity surgery = new SurgeryDetailsEntity(
                1, "Ticket123", "Surgery A", "2 hours", new Date(), 5, "High", "Open",
                "Agent1", "Doctor1, Doctor2", "Hospital XYZ"
        );

        // Test the getter methods
        assertEquals(1, surgery.getId());
        assertEquals("Ticket123", surgery.getTicketId());
        assertEquals("Surgery A", surgery.getSurgeryName());
        assertEquals("2 hours", surgery.getDuration());
        assertNotNull(surgery.getDate());
        assertEquals(5, surgery.getItemsOrdered());
        assertEquals("High", surgery.getPriority());
        assertEquals("Open", surgery.getStatus());
        assertEquals("Agent1", surgery.getAssignedAgent());
        assertEquals("Doctor1, Doctor2", surgery.getDoctorList());
        assertEquals("Hospital XYZ", surgery.getHospitalName());

        // Test the setter methods
        surgery.setId(2);
        assertEquals(2, surgery.getId());

        surgery.setTicketId("Ticket456");
        assertEquals("Ticket456", surgery.getTicketId());

        surgery.setSurgeryName("Surgery B");
        assertEquals("Surgery B", surgery.getSurgeryName());

        surgery.setDuration("3 hours");
        assertEquals("3 hours", surgery.getDuration());

        Date newDate = new Date();
        surgery.setDate(newDate);
        assertEquals(newDate, surgery.getDate());

        surgery.setItemsOrdered(10);
        assertEquals(10, surgery.getItemsOrdered());

        surgery.setPriority("Low");
        assertEquals("Low", surgery.getPriority());

        surgery.setStatus("Closed");
        assertEquals("Closed", surgery.getStatus());

        surgery.setAssignedAgent("Agent2");
        assertEquals("Agent2", surgery.getAssignedAgent());

        surgery.setDoctorList("Doctor3, Doctor4");
        assertEquals("Doctor3, Doctor4", surgery.getDoctorList());

        surgery.setHospitalName("Hospital ABC");
        assertEquals("Hospital ABC", surgery.getHospitalName());
    }
}
