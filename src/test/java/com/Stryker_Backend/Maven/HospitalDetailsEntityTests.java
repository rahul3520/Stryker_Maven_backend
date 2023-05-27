package com.Stryker_Backend.Maven;

import com.Stryker_Backend.Maven.entity.dao.HospitalDetailsEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HospitalDetailsEntityTests {

    @Test
    public void testHospitalDetailsEntity() {
        // Create a HospitalDetailsEntity object


        HospitalDetailsEntity hospital = new HospitalDetailsEntity(
                1, "Type", "Name", "Requested By", "Post Office", "City", "State", "Pincode", "Phone Number"
        );

        // Test the getter methods
        assertEquals(1, hospital.getId());
        assertEquals("Type", hospital.getCustomerType());
        assertEquals("Name", hospital.getCustomerName());
        assertEquals("Requested By", hospital.getRequestedBy());
        assertEquals("Post Office", hospital.getPostOffice());
        assertEquals("City", hospital.getCity());
        assertEquals("State", hospital.getState());
        assertEquals("Pincode", hospital.getPincode());
        assertEquals("Phone Number", hospital.getPhoneNumber());

        // Test the setter methods
        hospital.setId(2);
        assertEquals(2, hospital.getId());

        hospital.setCustomerType("New Type");
        assertEquals("New Type", hospital.getCustomerType());

        hospital.setCustomerName("New Name");
        assertEquals("New Name", hospital.getCustomerName());

        hospital.setRequestedBy("New Requested By");
        assertEquals("New Requested By", hospital.getRequestedBy());

        hospital.setPostOffice("New Post Office");
        assertEquals("New Post Office", hospital.getPostOffice());

        hospital.setCity("New City");
        assertEquals("New City", hospital.getCity());

        hospital.setState("New State");
        assertEquals("New State", hospital.getState());

        hospital.setPincode("New Pincode");
        assertEquals("New Pincode", hospital.getPincode());

        hospital.setPhoneNumber("New Phone Number");
        assertEquals("New Phone Number", hospital.getPhoneNumber());
    }
}

