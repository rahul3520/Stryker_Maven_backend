package com.Stryker_Backend.Maven;

import com.Stryker_Backend.Maven.entity.dao.HospitalDetailsEntity;
import com.Stryker_Backend.Maven.entity.dao.OtherTicketsEntity;
import com.Stryker_Backend.Maven.entity.dao.SurgeryDetailsEntity;
import com.Stryker_Backend.Maven.repository.HospitalDetailsRepository;
import com.Stryker_Backend.Maven.repository.OtherTicketsRepository;
import com.Stryker_Backend.Maven.repository.SurgeryDetailsRepository;
import com.Stryker_Backend.Maven.service.TicketDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TicketDetailsServiceTests {

    @Mock
    private SurgeryDetailsRepository surgeryDetailsRepository;

    @Mock
    private HospitalDetailsRepository hospitalDetailsRepository;

    @Mock
    private OtherTicketsRepository otherTicketsRepository;

    @InjectMocks
    private TicketDetailsServiceImpl ticketDetailsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetSurgeryDetails() {
        // Mocking the repository
        List<SurgeryDetailsEntity> expectedSurgeryDetails = Arrays.asList(
                new SurgeryDetailsEntity(1, "Surgery 1"),
                new SurgeryDetailsEntity(2, "Surgery 2")
        );
        when(surgeryDetailsRepository.findAll()).thenReturn(expectedSurgeryDetails);

        // Calling the service method
        List<SurgeryDetailsEntity> actualSurgeryDetails = ticketDetailsService.GetSurgeryDetails();

        // Verifying the result
        assertEquals(expectedSurgeryDetails, actualSurgeryDetails);
        verify(surgeryDetailsRepository, times(1)).findAll();
    }

    @Test
    void testGetFirstSurgeryDetails() {
        // Mocking the repository
        int row = 1;
        SurgeryDetailsEntity expectedSurgeryDetails = new SurgeryDetailsEntity(1, "Surgery 1");
        when(surgeryDetailsRepository.findById(row)).thenReturn(Optional.of(expectedSurgeryDetails));

        // Calling the service method
        Optional<SurgeryDetailsEntity> actualSurgeryDetails = ticketDetailsService.GetFirstSurgeryDetails(row);

        // Verifying the result
        assertEquals(Optional.of(expectedSurgeryDetails), actualSurgeryDetails);
        verify(surgeryDetailsRepository, times(1)).findById(row);
    }

    @Test
    void testGetHospitalDetails() {
        // Mocking the repository
        String customerName = "John Doe";
        List<HospitalDetailsEntity> expectedHospitalDetails = Arrays.asList(
                new HospitalDetailsEntity(1, "Hospital 1"),
                new HospitalDetailsEntity(2, "Hospital 2")
        );
        when(hospitalDetailsRepository.FetchHospitalDetails(customerName)).thenReturn(expectedHospitalDetails);

        // Calling the service method
        List<HospitalDetailsEntity> actualHospitalDetails = ticketDetailsService.GetHospitalDetails(customerName);

        // Verifying the result
        assertEquals(expectedHospitalDetails, actualHospitalDetails);
        verify(hospitalDetailsRepository, times(1)).FetchHospitalDetails(customerName);
    }

    @Test
    void testGetAllOtherTickets() {
        // Mocking the repository
        String ticketNumber = "T123";
        List<OtherTicketsEntity> expectedOtherTickets = Arrays.asList(
                new OtherTicketsEntity(1, "Ticket 1"),
                new OtherTicketsEntity(2, "Ticket 2")
        );
        when(otherTicketsRepository.FindAllOtherTickets(ticketNumber)).thenReturn(expectedOtherTickets);

        // Calling the service method
        List<OtherTicketsEntity> actualOtherTickets = ticketDetailsService.GetAllOtherTickets(ticketNumber);

        // Verifying the result
        assertEquals(expectedOtherTickets, actualOtherTickets);
        verify(otherTicketsRepository, times(1)).FindAllOtherTickets(ticketNumber);
    }

    @Test
    void testGetbyTicketId() {
        // Mocking the repository
        String ticketId = "123";
        List<SurgeryDetailsEntity> expectedSurgeryDetails = Arrays.asList(
                new SurgeryDetailsEntity(1, "Surgery 1"),
                new SurgeryDetailsEntity(2, "Surgery 2")
        );
        when(surgeryDetailsRepository.FindbyTicketId(ticketId)).thenReturn(expectedSurgeryDetails);

        // Calling the service method
        List<SurgeryDetailsEntity> actualSurgeryDetails = ticketDetailsService.GetbyTicketId(ticketId);

        // Verifying the result
        assertEquals(expectedSurgeryDetails, actualSurgeryDetails);
        verify(surgeryDetailsRepository, times(1)).FindbyTicketId(ticketId);
    }
}
