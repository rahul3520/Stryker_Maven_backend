package com.Stryker_Backend.Maven;

import com.Stryker_Backend.Maven.controller.TicketDetailsController;
import com.Stryker_Backend.Maven.entity.dao.HospitalDetailsEntity;
import com.Stryker_Backend.Maven.entity.dao.OtherTicketsEntity;
import com.Stryker_Backend.Maven.entity.dao.SurgeryDetailsEntity;
import com.Stryker_Backend.Maven.service.TicketDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TicketDetailsControllerTests {

    @Mock
    private TicketDetailsService ticketDetailsService;

    @InjectMocks
    private TicketDetailsController ticketDetailsController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ticketDetailsController).build();
    }

    @Test
    public void testViewSurgeryDetails() throws Exception {
        SurgeryDetailsEntity surgery1 = new SurgeryDetailsEntity();
        surgery1.setId(1);
        SurgeryDetailsEntity surgery2 = new SurgeryDetailsEntity();
        surgery2.setId(2);
        List<SurgeryDetailsEntity> surgeries = Arrays.asList(surgery1, surgery2);

        when(ticketDetailsService.GetSurgeryDetails()).thenReturn(surgeries);

        mockMvc.perform(get("/viewAllSurgeryDetails"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));

        verify(ticketDetailsService).GetSurgeryDetails();
    }

    @Test
    public void testLoadFirstSurgeryDetails() throws Exception {
        SurgeryDetailsEntity surgery = new SurgeryDetailsEntity();
        surgery.setId(1);
        Optional<SurgeryDetailsEntity> optionalSurgery = Optional.of(surgery);

        when(ticketDetailsService.GetFirstSurgeryDetails(1)).thenReturn(optionalSurgery);

        mockMvc.perform(get("/viewFirstRowOfSurgeryDetails"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));

        verify(ticketDetailsService).GetFirstSurgeryDetails(1);
    }

    @Test
    public void testFindSurgeryDetails() throws Exception {
        SurgeryDetailsEntity searchSurgery = new SurgeryDetailsEntity();
        searchSurgery.setTicketId("T123");

        SurgeryDetailsEntity surgery1 = new SurgeryDetailsEntity();
        surgery1.setId(1);
        surgery1.setTicketId("T123");
        SurgeryDetailsEntity surgery2 = new SurgeryDetailsEntity();
        surgery2.setId(2);
        surgery2.setTicketId("T123");
        List<SurgeryDetailsEntity> surgeries = Arrays.asList(surgery1, surgery2);

        when(ticketDetailsService.GetbyTicketId("T123")).thenReturn(surgeries);

        mockMvc.perform(post("/viewTicketDetails")
                        .content("{\"ticketId\":\"T123\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));

        verify(ticketDetailsService).GetbyTicketId("T123");
    }

    @Test
    public void testFindHospitalDetails() throws Exception {
        String currentHospital = "Hospital1";

        HospitalDetailsEntity hospital1 = new HospitalDetailsEntity();
        hospital1.setId(1);
        HospitalDetailsEntity hospital2 = new HospitalDetailsEntity();
        hospital2.setId(2);
        List<HospitalDetailsEntity> hospitals = Arrays.asList(hospital1, hospital2);

        when(ticketDetailsService.GetHospitalDetails(currentHospital)).thenReturn(hospitals);

        mockMvc.perform(get("/viewHospitalDetails/{currentHospital}", currentHospital))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));

        verify(ticketDetailsService).GetHospitalDetails(currentHospital);
    }

    @Test
    public void testFindOtherTickets() throws Exception {
        String ticketId = "T123";

        OtherTicketsEntity ticket1 = new OtherTicketsEntity();
        ticket1.setId(1);
        OtherTicketsEntity ticket2 = new OtherTicketsEntity();
        ticket2.setId(2);
        List<OtherTicketsEntity> tickets = Arrays.asList(ticket1, ticket2);

        when(ticketDetailsService.GetAllOtherTickets(ticketId)).thenReturn(tickets);

        mockMvc.perform(get("/viewOtherTickets")
                        .param("ticketId", ticketId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));

        verify(ticketDetailsService).GetAllOtherTickets(ticketId);
    }
}
